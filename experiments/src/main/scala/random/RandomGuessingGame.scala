package random

import console.FakeConsole
import zio._

val low  = 1
val high = 10

val prompt =
  s"Pick a number between $low and $high: "

// TODO Determine how to handle .toInt failure possibility
def checkAnswer(
    answer: Int,
    guess: String
): String =
  if answer == guess.toInt then
    "You got it!"
  else
    s"BZZ Wrong!! Answer was $answer"

def checkAnswerTry(
    answer: Int,
    guess: String
): String =
  try
    if answer == guess.toInt then
      "You got it!"
    else
      s"BZZ Wrong!! Answer was $answer"
  catch
    case _ =>
      "User did not provide an integer. Invalid input: " +
        guess

def checkAnswerZ1(
    answer: Int,
    guess: String
): ZIO[Any, Nothing, String] =
  ZIO
    .attempt(guess.toInt)
    .map(i =>
      if answer == i then
        "You got it!"
      else
        s"BZZ Wrong!! Answer was $answer"
    )
    .catchAll(_ =>
      ZIO.succeed("Invalid input: " + guess)
    )

def checkAnswerZ2(
    answer: Int,
    guess: String
): ZIO[Any, Nothing, String] =
  ZIO
    .attempt(guess.toInt)
    .map(i =>
      if answer == i then
        "You got it!"
      else
        s"BZZ Wrong!! Answer was $answer"
    )
    .orElseSucceed("Invalid input: " + guess)

def checkAnswerZ3(
    answer: Int,
    guess: String
): ZIO[Any, Nothing, String] =
  ZIO
    .attempt(guess.toInt)
    .orElseFail("Invalid input:  " + guess)
    .map(i =>
      if answer == i then
        "You got it!"
      else
        s"BZZ Wrong!! Answer was $answer"
    )
    .merge

def checkAnswerZ4(
    answer: Int,
    guess: String
): ZIO[Any, Nothing, String] =
  ZIO
    .attempt(guess.toInt)
    .mapBoth(
      _ => "Invalid input:  " + guess,
      i =>
        if answer == i then
          "You got it!"
        else
          s"BZZ Wrong!! Answer was $answer"
    )
    .merge

// After writing so many variations of the function above,
// I suspect that what we _really_ need to do is break up the logic.
// Both ZIO and vanilla Scala code should get simpler

def parse(guess: String) =
  ZIO
    .attempt(guess.toInt)
    .orElseFail("Invalid input:  " + guess)

def checkAnswerZSplit(
    answer: Int,
    guess: String
): ZIO[Any, Nothing, String] =
  parse(guess)
    .map(i =>
      if answer == i then
        "You got it!"
      else
        s"BZZ Wrong!! Answer was $answer"
    )
    .merge

val sideEffectingGuessingGame =
  for
    _ <- Console.print(prompt)
    answer = scala.util.Random.between(low, high)
    guess <- Console.readLine
    response = checkAnswer(answer, guess)
  yield prompt + guess + "\n" + response

object runSideEffectingGuessingGame
    extends ZIOAppDefault:
  def run =
    sideEffectingGuessingGame
      .withConsole(FakeConsole.single("3"))
      .debug("Side effecting results")

val effectfulGuessingGame =
  for
    _ <- Console.print(prompt)
    answer <-
      RandomBoundedInt.nextIntBetween(low, high)
    guess    <- Console.readLine
    response <- checkAnswerZSplit(answer, guess)
  yield prompt + guess + "\n" + response

object RunEffectfulGuessingGame
    extends ZIOAppDefault:
  def run =
    effectfulGuessingGame
      .withConsole(FakeConsole.single("3"))
      .provideLayer(RandomBoundedInt.live)

object RunEffectfulGuessingGameTestable
    extends ZIOAppDefault:
  def run =
    effectfulGuessingGame
      .debug("Result")
      .withConsole(FakeConsole.single("3"))
      .provideLayer(RandomBoundedIntFake(Seq(3)))

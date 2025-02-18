package streams

import zio.*
import zio.stream.*
import zio.test.Gen

case class Request(response: Code, path: Path)

trait HttpRequestStream:
  def requests: Stream[Nothing, Request]

object HttpRequestStream:
  object Live extends HttpRequestStream:
    override def requests
        : Stream[Nothing, Request] =
      ZStream
        .repeatZIO(randomRequest)
        .schedule(Schedule.spaced(100.millis))

  private val randomRequest =
    for
      code <- Code.random
      path <- Path.random
    yield Request(code, path)

enum Code:
  case Ok,
    BadRequest,
    Forbidden

object Code:
  val random =
    randomElementFrom(Code.values.toList)

case class Path(segments: Seq[String]):
  override def toString: String =
    segments.mkString("/")

object Path:
  val random: ZIO[Any, Nothing, Path] =
    for
      generator <-
        randomElementFrom(Random.generators)
      path <- generator
    yield path

  def apply(first: String, rest: String*): Path =
    Path(Seq(first) ++ rest)

  private object Random:
    private val generic
        : ZIO[Any, Nothing, Path] =
      val genericPaths =
        List(
          "login",
          "preferences",
          "settings",
          "home",
          "latest",
          "logout"
        )

      for section <-
          randomElementFrom(genericPaths)
      yield Path(s"/$section")

    private val user: ZIO[Any, Nothing, Path] =
      val userSections =
        List(
          "activity",
          "status",
          "collaborators"
        )

      for
        userId <- zio.Random.nextIntBounded(1000)
        section <-
          randomElementFrom(userSections)
      yield Path(s"/user/$userId/$section")

    val generators
        : List[ZIO[Any, Nothing, Path]] =
      List(generic, user)
  end Random

end Path

private[streams] def randomElementFrom[T](
    collection: List[T]
): ZIO[Any, Nothing, T] =
  for idx <-
      Random.nextIntBounded(collection.length)
  yield collection(idx)

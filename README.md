# Effect-Oriented Programming

***Creating Reliable Systems with Scala 3 and ZIO 2***

## Latest Preview Builds:

* [PDF](https://leanpub.com/s/fDHMG3a91OtuihppckOyMA.pdf)

* [EPUB](https://leanpub.com/s/fDHMG3a91OtuihppckOyMA.epub)

## Developer Notes

Steps for configuring your environment to run the book examples and build the book.

### First, perform the [Basic Installation Instructions](https://github.com/EffectOrientedProgramming/Examples#effect-oriented-programming-book-examples)

### Commands for Building & Running the Book Code

* Clone this repository onto your machine.

**NOTE:** For all the commands shown here, first start `sbt` ***In A Terminal Shell***.
Do not use IntelliJ IDEA's "sbt shell" window, which doesn't work correctly and will cause problems.
(It's OK to use the IntelliJ "Terminal" window).
Run `sbt` without any arguments to enter `sbt` console mode.
Once you start `sbt` you will see a prompt that looks like:

```text
sbt:EffectOrientedProgramming>
```

* Contributors, to ensure you don't break the build and/or inconvenience your collaborators,
  execute this script in the project root to set up our hooks:

  ```text
  ./bin/setupGitHooks.sh
  ```

* Compile the Chapters:

  ```text
  sbt:EffectOrientedProgramming> mdoc
  ```

* View the generated manuscripts:
  1. Run `mdoc` in watch mode:

    ```text
    sbt:EffectOrientedProgramming> mdoc --watch
    ```

  1. Open: [http://localhost:4000](http://localhost:4000)

* The `src` directory is a playground and you can run a `main` this way:

  ```text
  sbt:EffectOrientedProgramming> runMain HelloZio.hello
  ```

* To run continuously, precede the command with `~`:

  ```text
  sbt:EffectOrientedProgramming> ~runMain HelloZio.hello
  ```

* To pick a main from all available options, use the `run` task:

  ```text
  sbt:EffectOrientedProgramming> run
  ```

## Miscellaneous Notes

* Each chapter has a single namespace.
  The package name is automatically created from the chapter name; e.g. `package monads` from `05_Monads.md`.
  If you need a further namespaces, make an `object`.

* To wipe out local changes: `git reset --hard HEAD`

* Make pull commands rebase instead of merge: `git config --global pull.rebase true`.
  Explanation and [suggested default configurations](https://spin.atomicobject.com/2020/05/05/git-configurations-default/).

* Separate the exercises from the book. The end of each atom simply references
  the website for exercises. This way the exercises can be changed without
  modifying the book.

* Try using Jen (from the bookstore) as a copyeditor, to improve and
  speed up the process.

* Use `functionName()` (with parentheses but without parameters) to indicate functions in prose.

* Possibly change to tables generated by a graphics program instead of Markdown tables.

* Github as the "source of truth" repository for the book. Authors have
  full commit privileges, and normally commit rather than doing pull requests.
  Contributors use pull requests.

* When you do a commit, add a timestamp indicating how
  much work you put in on that commit. This is not a perfect solution but it
  does provide more data. Format for Git summary:

  ```text
  <Brief description> #author1 #author2 ... #authorN #time Xh Ym
  ```

  Where `X` and `Y` are numbers indicating hours and minutes. `X` can be
  a floating-point number or an integer, while `Y` must be an integer. `Xh` is
  not a required argument.

* Improved style-checking system (spelling, grammar, formatting). Piggyback on
  VSCode and/or IntelliJ.

* Potential: automatic conversion of book into teaching materials (slides).

## Publishing

* eBook through Leanpub.

* Print book through Ingram.

* Print-ready pages from Leanpub.

* Will use the new Markua syntax for automatic generation of the index.

Note that the last two points mean that going from eBook to print book becomes
virtually instantaneous, and does not collect baggage in the process (extra
things that require maintenance, like an index and custom page layout).

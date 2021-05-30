# AtomicScala3
Atomic Scala rewritten for Scala 3

**Note:** *This was originally written in May and there may be some outdated topics. In
addition, it might reflect frustrations I had at the time with the Kotlin book
process. Most ideas here are not fixed in stone.*

## Goals

- Add new atoms for new features and new concepts (e.g. simplified monad intro,
  important libraries, etc.).

- Update exercises and solutions; make solutions work inside Intellij EDU system.
  Minimum of 3 exercises per atom, for teaching purposes.

- Use new Scala scripting for introductory sections, to produce simpler intro examples.
  However, all examples must still have automatic verification.

- Improve example verification system (AtomicTest). Ideally it can be used for
  all examples starting with the first (script) ones, and not introduced later in the book.

- Improved onboarding experience for example code repository (much can be copied
  from Atomic Kotlin).

- New examples and text can be adapted from Atomic Kotlin when appropriate.

- Possibly more and better diagrams, where appropriate.

## Changes

- Adopt the example subdirectory approach used in Atomic Kotlin, where each
  atom has its own subdirectory.

- We'll probably want to add sections as in Atomic Kotlin.

- Separate the exercises from the book. The end of each atom simply references
  the website for exercises. This way the exercises can be changed without
  modifying the book.

- Move "how to use the command line" stuff to the Github example repo README
  (as was done with Atomic Kotlin; most/all of that work can be reused).

- Try using Jen (from the bookstore) as a copyeditor, to improve and
  speed up the process.

- Use `functionName()` (with parentheses but without parameters) to indicate functions in prose.

- Find all usages of "next atom" and "previous atom" and change to links, to
  allow easier reorganization of atoms.

- Consider changing `is` to `eq` for atomictest (not sure about this).

- Modify for Leanpub Markdown; check to see whether Markua is ready for prime time.

- Possibly change to tables generated by a graphics program instead of Markdown tables.

## Tools

- Github as the "source of truth" repository for the book. Authors have
  full commit privileges (normally you'll commit rather than doing pull requests).

- When you do a commit, add a timestamp (in the format Bill uses) indicating how
  much work you put in on that commit. This is not a perfect solution but it
  does provide more data.

- Unified tool set buildable from scratch from the github repo. No custom tools
  for one author and not the others. This toolset might be better placed in
  the public example code repository, so it's available to the reader who
  wants to see it (vs. the private AtomicScala3 repository).

- Improve system for extracting and testing the book's code and converting
  it into the example code repository along with build system configuration.
  (Probably write it in Scala).

- It would be ideal to create the core tooling in Scala. By "core tooling," I
  mean the tools that everyone is using regularly -- in particular, the
  code-extraction, building and example-verification portion.

- I have a large set of tools that I have previously built in Python for other
  projects which I will likely bring over as needed. If these become part of the
  core tooling, they can be converted to Scala. Writing tools in Scala is a good
  objective but if it becomes cumbersome we not should hesitate to use Python.

- Improved style-checking system (spelling, program issues like
  formatting & line width, etc.). Consider piggybacking on something like
  VSCode or IntelliJ.

- Potential: automatic conversion of book into teaching materials (slides).

## Publishing

- eBook through Leanpub.

- Print book through Ingram.

- Print-ready pages from Leanpub.

- No index (as per Atomic Kotlin), relies on "Atomic" structure to be index-like.

Note that the last two points mean that going from eBook to print book becomes
virtually instantaneous, and does not collect baggage in the process (extra
things that require maintenance, like an index and custom page layout).

# The Experience

> To create the foundation for a good working relationship, we need to discover
> each other's vision and needs, and then see whether there's a strategy that
> can meet those, for everyone.

## My Personal Vision

If it can be an enjoyable experience, I'd like to see if there's a way to reuse
the material in Atomic Scala, and see what happens. I'm sure the learning
experience would be stimulating.

There's probably not a big market for it. I don't see myself pursuing Scala in
any way. If there seemed to be demand, I could see turning the book into an
online course (see the last point in "Tools"), but I doubt that would be useful
for anything other than practice. I could imagine small-group (fits into the
coworking space), high-priced seminars in CB but only if there is clear demand.

## My Needs

1. I have a need for enjoyment. This book needs to be a pleasant and fun
experience. If it isn't, I'd rather be doing something else.

2. I have a need for ease. I imagine my role primarily as editor and manager,
and I'd also get it onto Leanpub and into print, get the cover designed, etc --
all the surrounding tasks. I'd also work together on tooling (I have a lot of
tooling in place, and can modify it as necessary).

I don't have a strong investment or impetus to finish this book if the project
doesn't work out, so I think it would be easy to walk away from it if it fails.
For that reason, I don't want to put up an early-access edition before it's
clear that the book is far enough along; if we sold that and then the project
didn't work out, I'd feel obligated to finish it.

## Your Vision

*Questions like these*: What do you imagine and hope will happen by doing this
project? Do you want to be more represented in the Scala community, or help
with your position at your company? Are you hoping to make a contribution to
the community? Do you want to use the book as a foundation for teaching? What
doors do you imagine opening when the book is out? What else do you imagine
about doing this book? How will this project make your life better?

## Your Needs

- (*Questions like these...*)

- What kinds of accomodations do you need to be satisfied and productive on this project?

- What kind of time do you want to give to it?

- How do you envision the financial structure of this project?

- When do you imagine it will be done?


--------------------

*Nothing wrong with having a strategic objective. Also nothing wrong with
thinking about how to get there, and even planning the first few steps. But if
that plan can't change dynamically based on inspection and feedback as you
move forward, there's no agility.*&mdash;[Allen Holub](https://twitter.com/allenholub)


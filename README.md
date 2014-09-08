# frontmatter

[![Build Status](https://travis-ci.org/liquidz/frontmatter.svg?branch=master)](https://travis-ci.org/liquidz/frontmatter)
[![Dependency Status](https://www.versioneye.com/user/projects/540c4b64ccc023ede900024e/badge.svg?style=flat)](https://www.versioneye.com/user/projects/540c4b64ccc023ede900024e)

A Clojure library designed to parse front matter from a file.

Supported front matter formats are follwoing:

 * YAML
 * JSON
 * EDN

## Installation

Add following dependency to your `profject.clj`.

[![Clojars Project](http://clojars.org/frontmatter/latest-version.svg)](http://clojars.org/frontmatter)

## Usage

```clojure
(require '[frontmatter.core :as fm])

(fm/parse "foo.txt")
;=> {:frontmatter {:foo "bar"}
     :body "this is body"}
```

## Front matter formats

### YAML
 * YAML front matter is separated by `---`.
```
---
hello: "world"
nums:
  - one
  - two
  - three
---

this is body
```

### JSON
 * JSON front matter is separated by `;;;`.
```
;;;
"hello": "world",
"nums": [
    "one",
    "two",
    "three"
]
;;;

this is body
```

### EDN
 * EDN front matter is separated by `###`.
```
###
:hello "world"
:nums [
    "one"
    "two"
    "three"
]
###

this is body
```

## License

Copyright (C) 2014 Masashi Iizuka ([@uochan](http://twitter.com/uochan))

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

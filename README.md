# frontmatter

A Clojure library designed to parse front matter from a file.

Supported front matter formats are follwoing:

 * YAML
 * JSON
 * EDN

## Installation

 * FIXME

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

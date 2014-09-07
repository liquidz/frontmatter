(defproject frontmatter "0.0.1"
  :description "A Clojure library designed to parse front matter from a file"
  :url "https://github.com/liquidz/frontmatter"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/data.json "0.2.5"]
                 [circleci/clj-yaml "0.5.2"]]

  :profiles {:dev {;:global-vars {*warn-on-reflection* true}
                   :dependencies [[midje "1.6.3" :exclusions [org.clojure/clojure]]
                                  [org.clojars.runa/conjure "2.1.3"]]}}
  :plugins [[lein-midje "3.1.3"]])

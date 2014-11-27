(ns frontmatter.core
  (:require
    [clojure.string    :as str]
    [clojure.data.json :as json]
    [clojure.edn       :as edn]
    [clj-yaml.core     :as yaml]))

(defn- split-lines
  [lines delim]
  (let [x (take-while #(not= delim %) lines)]
    (list x (drop (+ 1 (count x)) lines))))

(defn- parse-yaml
  [s]
  (yaml/parse-string s))

(defn- parse-json
  [s]
  (json/read-str (str "{" s "}")
                 :key-fn keyword))

(defn- parse-edn
  [s]
  (edn/read-string (str "{" s "}")))

(defn- select-parse-fn
  [first-line]
  (case first-line
    "---" parse-yaml
    ";;;" parse-json
    "###" parse-edn
    nil))

(defn parse-str
  [string]
  (let [original-body             string
        [first-line & rest-lines] (str/split-lines original-body)
        [frontmatter body]        (split-lines rest-lines first-line)]
    (if-let [parser (select-parse-fn first-line)]
      {:body (str/join "\n" body)
       :frontmatter (parser (str/join "\n" frontmatter))}
      {:frontmatter {} :body original-body})))

(defn parse
  [path]
  (parse-str (-> path slurp str/trim)))

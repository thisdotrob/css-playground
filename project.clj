(defproject css-playground "0.1.0-SNAPSHOT"
  :description "A ring server that serves up CSS experiments"
  :url "https://github.com/thisdotrob/css-playground"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring/ring-core "1.8.0"]
                 [ring/ring-devel "1.8.0"]
                 [ring/ring-jetty-adapter "1.8.0"]
                 [hiccup "1.0.5"]]
  :source-paths ["src" "dev"])

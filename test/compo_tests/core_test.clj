(ns compo-tests.core-test
  (:require [clojure.test :refer :all]
            [compo-tests.core :as compo-tests]
            [compo-tests.fixtures.system :refer [system-fixture]]))

(use-fixtures :each system-fixture)

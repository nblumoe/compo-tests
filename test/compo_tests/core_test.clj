(ns compo-tests.core-test
  (:require [clojure.test :refer :all]
            [compo-tests.core :as compo-tests]))

(use-fixtures :each compo-tests.fixtures.system/system-fixture)

(ns libpython-clj2.ffi-test
  (:require [libpython-clj2.python.ffi :as py-ffi]
            [libpython-clj2.python :as py]
            [clojure.test :refer [deftest is]]))


(py/initialize!)


(deftest module-type-name-test
  (let [main-mod (py-ffi/with-gil (py-ffi/PyImport_AddModule "__main__"))
        mod-type (py-ffi/pyobject-type main-mod)
        mod-name (py-ffi/pytype-name mod-type)]
    (is (= "module" mod-name))))
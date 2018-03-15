(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu []
  (print "Você perdeu")
)

(defn ganhou []
  (print "Você ganhou")
)

(defn letras-faltantes [palavra acertos]
  (remove (fn [letra] (contains? acertos (str letra))) palavra)
)

(defn acertou-a-palavra? [palavra acertos]
  (empty? (letras-faltantes palavra acertos))
)

(defn le-letra! []
  (read-line)
)

(defn acertou? [chute palavra]
  (.contains palavra chute)
)

;Função movidas para dentro da jogo para evitar o acumulo da pilha de chamadas
;(defn avalia-chute [chute vidas palavra acertos]
  ;(if (acertou? chute palavra)
    ;(jogo vidas palavra (conj acertos chute))
    ;(jogo (dec vidas) palavra acertos)
  ;)
;)

(defn jogo [vidas palavra acertos]
  (cond
    (= vidas 0) (perdeu)
    (acertou-a-palavra? palavra acertos) (ganhou)
    :else
      (let [chute (le-letra!)]
        (if (acertou? chute palavra)
          (jogo vidas palavra (conj acertos chute))
          (jogo (dec vidas) palavra acertos)
        )
      )
  )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

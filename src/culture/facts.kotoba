(ns culture.facts
  "Country-level regional-culture catalog for the United Arab Emirates
  (ARE) -- national dishes, protected products, beverages, crafts,
  festivals and heritage sites, per ADR-2607171400 addendum 2
  (cloud-itonami-municipality-culture-catalog Wave 1, in
  com-junkawasaki/root). Sibling namespace to `marketentry.facts` /
  `statute.facts` (ADR-2607141700); city-level counterparts live in the
  cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"ARE"
   [{:culture/id "are.dish.machboos"
     :culture/name "Machboos"
     :culture/name-local "مجبوس"
     :culture/country "ARE"
     :culture/kind :dish
     :culture/summary "Arab mixed rice dish of the kabsa family, known in the Gulf as machboos and commonly regarded as a national dish in Gulf Cooperation Council countries including the United Arab Emirates."
     :culture/url "https://en.wikipedia.org/wiki/Kabsa"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "are.dish.harees"
     :culture/name "Harees"
     :culture/name-local "هريس"
     :culture/country "ARE"
     :culture/kind :dish
     :culture/summary "Cracked-wheat and meat porridge commonly eaten in the Arab states of the Persian Gulf, a traditional Emirati dish popular during Ramadan and festive occasions."
     :culture/url "https://en.wikipedia.org/wiki/Harees"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "are.dish.balaleet"
     :culture/name "Balaleet"
     :culture/name-local "بلاليط"
     :culture/country "ARE"
     :culture/kind :dish
     :culture/summary "Sweet-and-savoury Arabian breakfast dish of vermicelli sweetened with sugar, cardamom, rose water and saffron and served with an egg omelette, with the United Arab Emirates listed among its places of origin."
     :culture/url "https://en.wikipedia.org/wiki/Balaleet"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "are.craft.al-sadu"
     :culture/name "Al Sadu"
     :culture/name-local "السدو"
     :culture/country "ARE"
     :culture/kind :craft
     :culture/summary "Traditional Bedouin weaving technique in geometric patterns practiced in the Gulf including the United Arab Emirates, inscribed on UNESCO's Intangible Cultural Heritage list."
     :culture/url "https://en.wikipedia.org/wiki/Al_Sadu"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "are.festival.dubai-shopping-festival"
     :culture/name "Dubai Shopping Festival"
     :culture/country "ARE"
     :culture/kind :festival
     :culture/summary "Annual month-long shopping and entertainment festival held in Dubai, United Arab Emirates, since 1996."
     :culture/url "https://en.wikipedia.org/wiki/Dubai_Shopping_Festival"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "are.heritage.al-ain"
     :culture/name "Cultural Sites of Al Ain"
     :culture/name-local "العين"
     :culture/country "ARE"
     :culture/kind :heritage
     :culture/summary "The Cultural Sites of Al Ain (Hafit, Hili, Bidaa Bint Saud and Oases Areas) in the Emirate of Abu Dhabi were inscribed in 2011 as the first UNESCO World Heritage Site in the United Arab Emirates."
     :culture/url "https://en.wikipedia.org/wiki/Al_Ain"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-are culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "ARE"))
                 " ARE entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))

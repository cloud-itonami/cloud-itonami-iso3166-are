(ns statute.facts
  "General-law compliance catalog for the United Arab Emirates (ARE)
  -- extends this repo's existing `marketentry.facts` (narrow
  public-procurement scope) with a second, orthogonal catalog of
  statutes a company generally must track for compliance. Mirrors
  cloud-itonami-iso3166-jpn/-usa/-esp/-swe/-nor/-dnk/-fin/-prt/-bel/-bra/-mex/-chl/-arg/-zaf/-col/-ury/-cri/-pan/-ecu/-pry/-gtm/-hnd/-ind/-ken/-tha's
  `statute.facts` (ADR-2607141700, cloud-itonami-compliance-fact-federation).

  Reuses this tick-window's already-verified capital/organization data
  from cloud-itonami-municipality-are-abu-dhabi (UAE Q878, Abu Dhabi
  Q1519, no P36 historical-capital bug).

  uaelegislation.gov.ae (the primary official federal legislation
  portal) returned HTTP 403 on every URL tried, including the direct
  PDF download endpoint.

  Federal Law No. 2 of 2015 on Commercial Companies is directly
  confirmed by reading WIPO Lex's own hosted PDF text (issued 25
  March 2015, published in Official Gazette 31 March 2015, entry into
  force 1 July 2015). NOTE: WebSearch indicates this law was later
  superseded by Federal Decree-Law No. 32 of 2021, which could not be
  directly verified because uaelegislation.gov.ae was unreachable --
  the 2015 law is cited here as the last version this project could
  independently confirm, and this caveat is recorded honestly rather
  than guessing at the newer law's exact text/dates.

  Federal Decree-Law No. 45 of 2021 on the Protection of Personal
  Data: the exact title and decree-law number were confirmed via a
  bilingual (English/Japanese) legal-translation memo published by
  Mereller (a specialized UAE law firm) -- a non-governmental but
  professionally-produced legal-translation source, distinct from a
  fabricated or marketing-only mirror. Multiple independent citing
  sources gave CONFLICTING issuance/signing dates (20 September 2021,
  26 September 2021, 27 November 2021, 28 November 2021) -- rather
  than guess among them, the entry-into-force date (2 January 2022),
  which every source consistently agreed on with zero contradiction,
  is used instead and the ambiguity is recorded here.

  A law not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of statute entries."
  {"ARE"
   [{:statute/id "are.federal-law-2-2015-commercial-companies"
     :statute/title "Federal Law No. 2 of 2015 on Commercial Companies"
     :statute/jurisdiction "ARE"
     :statute/kind :law
     :statute/law-number "Federal Law No. 2 of 2015"
     :statute/url "https://www.wipo.int/wipolex/edocs/lexdocs/laws/en/ae/ae042en.pdf"
     :statute/url-provenance :official-wipo-lex-mirror
     :statute/enacted-date "2015-03-25"
     :statute/retrieved-at "2026-07-16"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "are.federal-decree-law-45-2021-personal-data-protection"
     :statute/title "Federal Decree-Law No. 45 of 2021 on the Protection of Personal Data"
     :statute/jurisdiction "ARE"
     :statute/kind :law
     :statute/law-number "Federal Decree-Law No. 45 of 2021"
     :statute/url "https://protection-data.ae/wp-content/uploads/2023/10/federal-decret-law-45-uae.pdf"
     :statute/url-provenance :mereller-legal-translation-mirror
     :statute/enacted-date "2022-01-02"
     :statute/retrieved-at "2026-07-16"
     :statute/topic #{:data-protection :privacy}}]})

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
      :note (str "cloud-itonami-iso3166-are statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "ARE")) " ARE statutes seeded with "
                 "WIPO Lex/Mereller citations. Extend "
                 "`statute.facts/catalog`, never fabricate a law-id or URL.")})))

(defn by-topic [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))

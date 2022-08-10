# mutants-mercadolibre
DNA Mercadolibre

How to use the API

for mutants dna validation:
(POST)
http://localhost:8080/mutants/apiv1/mutant

json body like:

{
    "dna":["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}

for getting stats:
(GET)
http://localhost:8080/mutants/apiv1/stats


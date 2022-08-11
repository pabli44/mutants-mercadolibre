# mutants-mercadolibre
DNA Mercadolibre API
<br>
<br>
<br>
How to use:


LOCAL <br>
for mutants dna validation:<br>
(POST)<br>
http://localhost:8080/mutants/apiv1/mutant

json body like: <br>
{
    "dna":["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}

for getting stats:<br>
(GET)<br>
http://localhost:8080/mutants/apiv1/stats
<br><br>


APPENGINE<br>
for mutants dna validation:<br>
(POST)<br>
https://mutants-project-359021.uc.r.appspot.com/mutants/apiv1/mutant

json body like:<br>
{
"dna":["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}

for getting stats:<br>
(GET)<br>
https://mutants-project-359021.uc.r.appspot.com/mutants/apiv1/stats


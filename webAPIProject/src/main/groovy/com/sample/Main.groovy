package com.sample

import groovy.json.JsonSlurper

println "webAPIProject start!"

def urlString = "http://qiita.com/api/v2/tags?page=1&per_page=100"
def response = new URL(urlString).text
println response

ArrayList qiitaTagJson = new JsonSlurper().parseText(response) as ArrayList

assert qiitaTagJson[0].id == "Gunosy.go"
assert qiitaTagJson[0]["id"] == "Gunosy.go"
assert qiitaTagJson[0].get("id") == "Gunosy.go"

println "webAPIProject done!"
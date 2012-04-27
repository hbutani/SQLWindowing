package com.sap.hadoop.windowing.functions.marketbasket

basedir = "src/test/groovy"
String path = "$basedir/data/marketbasket"

File f = new File("$path/raw.txt")

File of = new File("$path/sample")
of.mkdirs()
of = new File("$path/sample/000000_0")
of.createNewFile()

int i = 0
entries = []

f.each { line ->
	String basket = "Basket $i"
	line.split(/ /).each { item ->
		entries << "$basket,$item\n"
	}
	i++
}

of.withWriter { out ->
	entries.each { e ->
		out << e
	}
}
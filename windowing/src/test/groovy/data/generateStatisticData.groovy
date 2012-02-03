package data

def basedir = "src/test/groovy"
def outFile = new File("$basedir/data/statistics/0000000_0")

def line = "121152almond antique burnished rose metallicManufacturer#1%d%d"


outFile.withWriter { writer ->
	for(i in 1..6)
	{
		writer.writeLine(sprintf(line, i, (7-i)))
	}
}


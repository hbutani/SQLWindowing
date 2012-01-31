package data

def basedir = "src/test/groovy"
def outFile = new File("$basedir/data/partvlarge/0000000_0")

def line = "121152almond antique burnished rose metallicManufacturer#1Brand#14PROMO PLATED TIN2JUMBO BOX1173.15e pinto beans h"

outFile.withWriter { writer ->
	for(i in 1..1000000)
	{
		writer.writeLine(line)
	}
}

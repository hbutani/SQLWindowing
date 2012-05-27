package com.sap.hadoop.windowing.functions.marketbasket

f = new File("/media/MyPassport/windowing/windowing/src/test/groovy/data/marketbasket/10000_8_db.txt")
dir = new File("/media/MyPassport/windowing/windowing/src/test/groovy/data/marketbasket/db10000")
dir.mkdirs()
of = new File("/media/MyPassport/windowing/windowing/src/test/groovy/data/marketbasket/db10000/000000_0")

int b= 0
of.withWriter { out ->
	f.each { line ->
	   //out.writeLine(line)
	   def items = line.split(" ").collect { it != "0" }
	   for(int i=0; i < items.size(); i++)
	   {
		   if ( items[i] )
		   {
			   out.writeLine("Basket $b,Item ${i+1}")
		   }
	   }
	   b++
	}
}

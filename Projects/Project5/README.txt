People: Blake Kim

Implimentation: 
To impliment the exact hash table for keywords.txt, compile KeywordsTextScan.java
and run code with: java KeywordsTextScan keywords.txt. To impliment the general hash
table for the test files, compile TextScan.java and run code like: java TextScan gettysburg.txt. 

Features:
All the non-empty chains are printed with their index position in the array, the chain length,
and the printed chain from start to finish. Some statistics that are included are the largest and
smallest chain, the total amount of items in the hash table, the number of empty positions in the array 
and the average length and median of the chain.

Credit:
As mentioned in the files, TextScan and KeywordsTextScan are modified from the original file found on
CSCI 1933 Spring 2020 Canvas page and the median function was taken from geeksforgeeks.org at the link
https://www.geeksforgeeks.org/median/

Progression of Hash and Reasons for implimenting Hash:
Originally, I first implimented a hash that simply summed each letter's unicode values and returned that.
It didn't give me an even spread and there were chains that were 30+. So I tried implimentating a hash that
summed and muliplied the unicode for all odd letters, which gave me a better result, but for some files the
chains were vary long. So to further distibute it I tried multiplying each returned result by the number of 
items in the file, which resulted in most files having max chain lengths of 4, but there were many duplicates
and searching the hash table and each chain for duplicates would be very expensive. So I finally landed on my
hash as described in the HashTable.java file. Moreover, for the exact hash, I simply tweaked the general case
since it worked fairly well. Although I had a better performing hash in terms of the max chains being smaller
than my current general hash, it had many more empty chains (20-25% empty) and a lower median and average across the
board compared to my current hash. So the reason I chose my general hash is because a good overall 
hash will distibute the values more equally and will have less empty space, over multiple different files.

Bugs/Problems:
None that I know of when implimenting test files.

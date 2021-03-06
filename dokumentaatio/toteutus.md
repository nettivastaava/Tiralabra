# **Toteutusdokumentti**

## **Ohjelman rakenne**

Ohjelman runko koostuu luokista Maze, DeadendFiller (DEF), BreadthFirst (BFS) ja Wallfollower (WF). Tämän lisäksi ohjelma sisältää luokat itsetoteutetuille tietorakenteille, jotka ovat Tile, MazeQueue ja SimpleStack. Yksinkertainen luokka Tile mukailee Javan luokkaa Point. Tile kuvastaa yhtä labyrintin ruutua, joka on joko sallittu tilasiirtymä, ns. käytävä, tai seinä. MazeQueue on nimensä mukaisesti jonorakenne, jota hyödynnetään osana leveyshakua. SimpleStack taas on yksinkertaistettu versio pinorakenteesta. Yksinkertaistus tarkoittaa lähinnä sitä, ettei rakenteelle ole toteutettu erillistä peek-metodia, koska sitä ei projektissa tarvita. Rakenteen käyttötarkoitus on tallettaa labyrintin umpikujat odottamaan käsittelyä (täyttämistä).

## **Algoritmien vertailu ja analyysi**

Todella pienillä ja suoraviivaisilla labyrinteilla WF ja BFS vaikuttavat olevan nopeimpia. Kuitenkin labyrintin kasvaessa huomasin yllätyksekseni, että DEF oli lähes poikkeuksetta nopein. Tätä havaintoa tuki myös se, että BFS:n suoritus (syklillisissä labyrinteissa) todella tehostui käyttämällä ensin umpikujantäyttöä. Toki tapauksissa, joissa lähtö- ja maalisolmut olivat riittävän lähellä toisiaan, DEF jäi selvästi taakse. Wallfollower ei syklillisissä labyrinteissä ole samalla tavalla vertailukelpoinen kahden muun algoritmin kanssa, sillä Walfollower ei tässä tapauksessa löydä välttämättä lyhyintä reittiä.

Alla on taulukoituna algoritmien suoritusnopeuksia (sekunteina) erikokoisilla labyrinteilla. Jokaisessa taulukon testissä on käytetty labyrinttia, jossa kuljettava reitti on valittu melko pitkäksi labyrintin kokoon verrattuna.

![speedtests](https://github.com/nettivastaava/MazeSolver/blob/master/dokumentaatio/kuvat/speedtests.png)
  

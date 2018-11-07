# Dojo Session du 05/11/2018

Basé sur l'énoncé suivant, une première version est livrée. 
Objectifs de la séance: remettre en question l'implantation proposée basée sur des arguments 
et procéder au refactoring.


## Story: Calcul de taxes

### Enoncé

Aucune taxe n'est appliquée sur les produits de première nécessité, à savoir la nourriture et les médicaments.
Une taxe sur la valeur ajoutée de 10% est appliquée sur les livres.
Une taxe sur la valeur ajoutée de 20% est appliquée sur tous les autres produits.

Une taxe additionnelle de 5% est appliquée sur les produits importés, sans exception.

Le montant de chacune des taxes est arrondi aux 5 centimes supérieurs, selon la règle suivante :

| Taxe calculée | Taxe imputée |
|---------------|--------------|
|          0.99 |         1.00 |
|          1.00 |         1.00 |
|          1.01 |         1.05 |
|          1.02 |         1.05 |

Lorsque l'on passe une commande, une facture est émise listant chacun des produits ainsi que leur
prix TTC ; au bas de la facture figurent le montant total (TTC) ainsi que le montant total des taxes.
Le montant TTC est calculé comme suit :
```
Pttc = Pht + somme(arrondi(Pht*t/100))
Pttc: Prix TTC
Pht : Prix hors taxes
t : taxe applicable
``` 

Ecrire une application, exécutable sur une JVM 1.8, qui imprime la facture détaillée pour chacun des
paniers suivants :

 
### INPUT

#### Input 1

* 2 livres à 12.49€
* 1 CD musical à 14.99€
* 3 barres de chocolat à 0.85€

#### Input 2

* 2 boïtes de chocolats importées à 10€
* 3 flacons de parfum importés à 47.50€

#### Input 3

* 2 flacons de parfum importés à 27.99€
* 1 flacon de parfum à 18.99€
* 3 boïtes de pilules contre la migraine à 9.75€
* 2 boïtes de chocolats importés à 11.25€

### OUTPUT

#### Output 1

* 2 livres à 12.49€ : 27,5€ TTC
* 1 CD musical à 14.99€ : 18€ TTC
* 3 barres de chocolat à 0.85€ : 2.55€ TTC

Montant des taxes : 5.53€
Total : 48.05€

#### Output 2

* 2 boïtes de chocolats importées à 10€ : 21€
* 3 flacons de parfum importés à 47.50€ : 178,15€

Montant des taxes : 36.65€
Total : 199.15€

#### Output 3

* 2 flacons de parfum importés à 27.99€ : 70€
* 1 flacon de parfum à 18.99€ : 22.8€
* 3 boïtes de pilules contre la migraine à 9.75€ : 29.25€
* 2 boïtes de chocolats importés à 11.25€ : 23.65€

Montant des taxes : 18.98
Total : 145,7

---------------------------------------------------------------

# CR session 05/11/2018

## Participants:

- Brice LEPORINI
- Adrien LOUSTAUNAU
- Odrick NGUAMA
- Nader HAJLAOUI

## Bilan

Le groupe a constaté que le block `switch... case` sur le type énumératif devrait être avantageusement remplacé par une interface et un ensemble d'implantations.

Le cas des produits d'importation a d'abord été géré par un flag, puis le groupe a proposé une option à base de décorateur.

Le sujet reste un terrain fertile pour d'autres katas.

## Evaluation de la séance et points à améliorer

Notes (sur 5): 5, 5, 4, 3

Globalement le groupe est satisfait de la séance. Toutefois il aurait été plus avantageux que le sujet soit livré avec les tests de l'énoncé, l'intention initiale était de mettre en évidence la lacune au niveau des tests.

Le partage du code entre les participants a un peu patiné, ce qui est à prévoir à l'avenir est une séquence `fork --> branch --> push --> pull request --> merge`.  

Le sujet n'était pas fonctionnel 😜 au début (NPE, résultats non conformes). 
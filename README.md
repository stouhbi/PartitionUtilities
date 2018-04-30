# PartitionUtilities

Utilitaire pour le partionnement d'une liste (`Set, List`) sous forme d'une liste de liste selon une variable représentant le nombre maximum de valeur dans chaque liste


## Comment utiliser

importer le projet sur eclipse

```
mvn clean install
```
pour télécharger les dépendances nécessaire.

### Les fonctionnalités


La class `Utils` dans le package `com.partition.utilities` contien 4 fonctions stariqueq:

```java
public static  <T> Collection<List<T>> partition(Collection<T> list, int size)
```

Permet le partionnoment d'une liste `List` selon l'odrer dans cette dernière. On peut utiliser la classe `Set` mais ceci ne permet pas de suivre l'objectif de cette dernière.


```java
public static  <T> Collection<List<T>> partition(T[] list, int size)
```

Permet de faire un partionnement ordonnée d'un tableau. L'exception ou la tableau ne contient pas de valeurs est géré par `EmptyArrayException`


```java
public static  <T> Collection<List<T>> partitionParallel(Collection<T> list, int size)
```

Permet le partionnement d'une liste `Set, List` sans respecter l'odrer en utilisant parallelStream afin d'assurer plus de rapidité.


```java
public static  <T> Collection<List<T>> partitionParallel(T[] list, int size)
```

Permet le partionnonement d'un tableau sans respecter l'ordre. L'exception ou la tableau ne contient pas de valeurs est géré par `EmptyArrayException`

```java
public static <T> boolean listEqualsIgnoreOrder(Collection<T> list1, Collection<T> list2)
```

permet de comparer si deux listes contiennent les mêmes valeurs sans respecter l'ordre


Les test unitiaire dans la classe `UtilsTest` permettent de tester les différentes fonctionnalité. On utilise la méthode `CollectionUtils.isEqualCollection` dans la dépendance `commons-collections4` pour comparer deux collections puisque `AssertEquals` ne permet pas de faire cela pour deux collections de types différents.

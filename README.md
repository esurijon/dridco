dridco
======

La interfaz Graph tiene el proposito de modelar un grafo los mas generico posible, por ello me vali del uso de genrics para determinar el tipo de datos tanto para vertices coma para lados.
Ademas expone los metodos de recorrido para grafos convencionales. Un handler se invoca al visitar cada vertice al recorrer el grafo, de este modo logro un buen desacople entre el algoritmo para recorrer el grafo y la logica para loscalculos requeridos.
Tambien pude optar optar por un patron template, para separar la logica de nogocio pero esto hubiera requerido que el codigo con el negocio se ate (herede) a una implementacion de Graph, lo cual ademas de no ser prolijo tambien podria tener complicaciones a la hora de aplicar la mismalogica sobre distintas implementaciones de Graph. De todos modos un claro ejemplo del patron template se aprecia en la clase RouteFinder y sus derivadas.

La clase InvalidPathException es una excepcion de negocio por lo tanto es chequeada y manejada adecuadamente. Por el contrario los metodos no implementados de Graph arrojan una RuntimeException.     

Tambien remarco que el uso de Graph con las implementaciones provistas es thread safe.
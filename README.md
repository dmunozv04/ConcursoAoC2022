# ConcursoAoC2022
## Tabla con mis estrellas:
<!--- advent_readme_stars table --->
## 2022 Results

| Day | Part 1 | Part 2 |
| :---: | :---: | :---: |
| [Day 1](https://adventofcode.com/2022/day/1) | ⭐ | ⭐ |
| [Day 2](https://adventofcode.com/2022/day/2) | ⭐ | ⭐ |
| [Day 3](https://adventofcode.com/2022/day/3) | ⭐ | ⭐ |
| [Day 4](https://adventofcode.com/2022/day/4) | ⭐ | ⭐ |
<!--- advent_readme_stars table --->
## Enlaces importantes

- [Crear *fork* de un repositorio](https://docs.github.com/en/get-started/quickstart/fork-a-repo)
- [Advent of Code](https://adventofcode.com/)

## Recomendaciones
### Manejo de archivos

Como los problemas de cada día son independientes los unos de los otros, lo más recomendable es separar cada día en diferentes directorios, pero puedes usar la estructura de ficheros que más cómoda te resulte.

Si usas Windows, ejecuta el siguiente comando en tu cmd una vez clonado el repositorio en el mismo directorio de tu repositorio local. Para ello, crear antes un archivo *lista.txt* con la salida generada por el siguiente script de Python:

```
for i in range(1,26):
    print('Dia%02d' % i)
```

Ejecutar en cmd:
```
FOR /F %1 IN (./lista.txt) DO mkdir %1
```

Si usas Linux, el siguiente comando permite crear un directorio/carpeta para cada día una vez hayas creado el *fork* de este repositorio y hayas clonado el repositorio creado en tu ordenador.

```
mkdir Dia{01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}
```

### Entrada/Salida

Lo más recomendable para el manejo de la entrada de los problemas es guardar la entrada en un fichero de texto plano (txt), y, o pasarlo por la entarda estándar, o hacer que la solución implementada para el problema abra y lea el archivo.

# Assignment 3 | Bridge Pattern

- **Name:** Alikhan Smagul
- **Group:** SE-2529
- **Topic:** A
- **Repository:** <https://github.com/alihzzz/SDP_Assignment3.git>
- **Base commit:** git rev-parse 9d0855b

## Role map

| Role | Class | Path |
|---|---|---|
| Abstraction | Shape | src/Shape.java |
| A1 | Circle | src/Circle.java |
| A2 | Square | src/Square.java |
| Implementor | Renderer | src/Renderer.java |
| I1 | VectorRenderer | src/VectorRenderer.java |
| I2 | RasterRenderer | src/RasterRenderer.java |
| I3 | AsciiRenderer | src/AsciiRenderer.java |
| Client | Main | src/Main.java |

## Where to look

- Bridge field: `private Renderer renderer` in `src/Shape.java`
- `execute()`: abstract in `Shape`, implemented in `Circle` and `Square`
- `setImplementation(...)`: `src/Shape.java`
- T5 check: `Main.checkSwitch(...)` in `src/Main.java`

## Run

```
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

## Expected results

```
T1 PASS | Circle + VectorRenderer | result=VECTOR circle radius=2
T2 PASS | Circle + RasterRenderer | result=RASTER circle radius=2
T3 PASS | Square + VectorRenderer | result=VECTOR square side=3
T4 PASS | Square + RasterRenderer | result=RASTER square side=3
T5 PASS | sameObject=true | stateUnchanged=true
 before=VECTOR circle radius=2 | after=RASTER circle radius=2
T6 PASS | Circle + AsciiRenderer | result=ASCII circle radius=2
T7 PASS | Square + AsciiRenderer | result=ASCII square side=3
SUMMARY: 7/7 PASS
```
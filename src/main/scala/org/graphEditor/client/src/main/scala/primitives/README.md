# Primitives overview

## Semantic

Primitives are the lowest abstraction layer between rendering engine and raw DOM elements.

They are atomic and can not contain any other Primitives, Layouts or Components.

Primitives is used for building components. Any component should contain a tree of primitives.

Primitives are reactive as any other Entities of rendering engine.

## Principles of Implementation

### Primitives classification

#### Target layers

* Canvas layer
> Used for rendering big count non-interactive objects
> Background layer: the lowest zIndex
* Scalable Vector Graphics layer
> Used for rendering medium count custom interactive geometry objects
> Middle layer: zIndex is between Canvas zIndex and HTML zIndex
* HTML layer
> Used for rendering objects with simple geometry, editable UI elements such as text inputs, text areas, etc.
> Top layer

#### Implementation

* Via SVG wrapper
* Via d3.js
* Via Canvas wrapper

#### Minimal set of parameters describing primitive

* Description[Double] (x, y)
* Description (IComponent, IComponent)
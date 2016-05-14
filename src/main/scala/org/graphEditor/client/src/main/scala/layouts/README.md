# Layouts

* Layouts are used for rendering compound object on particular layer.

* They are the only way for managing relative position of components.

## Rationale

* Needs of User Interface: it is an elegant and convenient way of structuring content on a web page.

* Abstraction layer between components and their coordinates.

* Drag & drop implementation is much easier to design because of splitting components and their positions.

## Requirements

* Drag & Drop implementation.

## Implementation

* Reactive Template with placeholders for child Components.

* Reactive Positions for child Components placement.

* Reactive Drag & Drop.

* Empty placeholders used for inserting new Components.

* Only Components can be children of Layouts.

## Descriptive sets

* Reactive Mapping between Layout structure and particular Rendering Layer.

* Reactive Positions of Components placed in particular layout.

* Reactive Positions of Primitives contained in particular Component.

# Textus/CNCF Immutable Infrastructure Document Project

Status: purpose/architecture-first source revision, 2026-11-13. PDF generation is
explicitly deferred. Native rendering and runtime acceptance are separate.

## Review comments — 2026-11-13

The [review note](../../../../../../docs/notes/immutable-infrastructure-guide-review.md)
records the requested purpose/architecture-first structure and neutral factual
writing style. The policy is now applied to shared Core, Japanese/English Documents
and the SmartDox manuscript. PDF regeneration and Drive updates remain deferred;
the PDF below is the earlier 11-chapter draft.

## Reader entry

[Bilingual SmartDox manuscript](index.dox) explains purpose and scope, concepts,
overall architecture, state boundaries, lifecycle behavior, security, configuration
and cost, implementation status and references, in that order. Elements,
responsibilities and their connections precede replacement procedures. CNCF's
intended state model separates durable business state, reconstructible resident
state and transient/uncertain work. Headings and prose use descriptive technical
language and distinguish design intent from delivered or qualified behavior.

The purpose chapter also describes replaceability as a design harness: operational
requirements become explicit state/dependency/lifecycle constraints and verification
conditions. It relates this effect to CI/CD and identifies the harness terminology
as this guide's synthesis, with primary background sources in the references.
This does not establish automatic design correctness or a delivered CNCF harness.
The conditions are defined per replacement/deployment unit, including cohesive
responsibilities, permitted dependencies, state ownership, interfaces and lifecycle.
Their maintenance is necessary for the selected operating method; actual tests and
deployment/replacement results check continuing conformance after changes.
The purpose and responsibility sections distinguish platform mechanisms from
component implementation contracts. Application-specific additions must follow
the same state/commit/lifecycle conditions, whether written by a person or an AI.
Qualification includes those additions on the actual business route; generated
scaffolding alone does not establish component conformance.

## Current reading order

1. Purpose and scope.
2. Concepts and applicability.
3. Overall architecture, including tier structure and responsibilities.
4. State management and application boundaries.
5. Lifecycle and operation: planned replacement, scheduled replacement/updates/switch-back, exceptions/failures.
6. Security relationship.
7. Configuration, quality targets and cost.
8. Implementation plan and qualification status.
9. Related documents and design sources.

The architecture chapter identifies artifacts/configuration, deployment,
entry/admission, execution, authoritative records, resident state/synchronization,
control/coordination and observation. Separate prose explains construction,
business-request/data and control/observation paths. These are logical
responsibilities; they do not prescribe a physical host count.

- [Availability and HA](../../availability/textus-cncf-availability-architecture.dox/README.md): continuity, authority, synchronization and transfer protocols.
- [Security](../../security/textus-cncf-security-architecture.dox/README.md): defense, containment, revocation and the limits of replacement.
- [Reactive architecture](../../reactive/textus-cncf-reactive-architecture.dox/README.md): residency, UoW and recovery.

## Source contract

Shared meaning is in `content/core.yaml`; complete localized Documents are in
`content/ja/document.yaml` and `content/en/document.yaml`. `index.dox` expresses
those Documents using paired language spans. The guide has nine chapters, four
subsections and seven tables. Recursive containment, child-Step reading Flow and
local explanation relations are authored separately. Sources follow the existing
direct `.dox` local-build contract; no
workflow descriptor or second locale-specific Core is introduced.

`build/document-project-targets.yaml` declares existing structure, reader and
article HTML routes for later selection. None was run in the initial source task.
The subsequently requested Japanese PDF is recorded below. HTML, images, slides,
video, packaging and public-site publication remain ungenerated.

## Design authority

The [current boundary note](../../../../../../docs/design/availability-guide-boundary.md)
describes guide ownership. CNCF owns the runtime design and Phase 108.
Planned replacement is the first delivery; IR-01 through IR-05 remain OPEN.
Do not interpret an architecture statement as verified storage durability,
automatic failover, host availability or arbitrary Running-work replay.

## Japanese PDF — 2026-11-13

The earlier 11-chapter manuscript was rendered through the existing `cozy pdf` Japanese
LaTeX business route: [local PDF](target/textus-cncf-immutable-infrastructure-ja.pdf),
A4, six pages. All pages were visually inspected, and all 106 Japanese paragraph,
caption, header and table-cell values were checked against extracted PDF text.

[Google Drive @Active copy](https://drive.google.com/file/d/1Mth0Btpo5a4gWe_x35hWxkyHjhRgYHgu/view?usp=drivesdk).
Connector metadata readback confirmed the destination folder and 177301-byte size.
This request generated no HTML, changed no runtime and performed no Git commit.

The PDF and @Active copy above predate the purpose/architecture-first source
revision. The current source-only request does not refresh either output.

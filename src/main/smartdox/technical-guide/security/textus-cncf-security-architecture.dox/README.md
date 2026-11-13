# Textus/CNCF Security Architecture Document Project

- `content/core.yaml`: shared recursive logic tree and stable semantic identities.
- `content/ja/document.yaml`, `content/en/document.yaml`: localized prose and explicit Core references.
- `index.dox`: bilingual SmartDox representation derived from both Documents.
- `build/document-project-targets.yaml`: the three native local HTML routes; structure/reader views select Japanese explicitly.
- `content/ja/confirmation-vocabulary.yaml`: Japanese confirmation UI wording.

## Requested confirmation

Run from this direct `.dox` project (through the repository's prescribed Cozy command execution route):

```text
cozy document-project build . --target document-structure-html
```

The output is `target/document-project/local-build/document-structure-html/index.html`. It presents containment, local logical structures, child-Step flow, and related prose. Generating the view is not human approval or publication.

Shared meaning changes belong in Core and the affected localized Documents. Wording changes belong in Document; reflect accepted prose in `index.dox`. Do not edit generated HTML as an authority.

The guide connects component independence and modeled rules to artifact inspection/distribution/admission, shared runtime security, and observation/recovery. Common authentication and authorization mechanisms apply component-specific policies; component, enforcement, and deployment boundaries are distinguished.

The explanation distinguishes standard-path protection, business-specific authorization, auditing/observability, and selected deployment/operational hardening. Patterns, profiles, and design/operation guides are identified as planned guidance. Each locale contains eight figures and six tables; editable SVG figures and corresponding PNG assets reside in `images/`. The standard-to-hardened and security-observation-audit figures show the new relationships; authorization-two-boundaries includes Entity permissions and policy inputs.

## Immutable infrastructure and HA — 2026-11-13

The shared Core-referenced Japanese/English prose and SmartDox manuscript now
relate intentional memory residency and persistence separation to replacement.
They distinguish planned drain/retention from failure fencing and incident
isolation. These are design explanations, not implementation acceptance.

- [Immutable infrastructure](../../immutable-infrastructure/textus-cncf-immutable-infrastructure.dox/README.md): why to adopt it and how to operate it.
- [Availability and HA](../../availability/textus-cncf-availability-architecture.dox/README.md): synchronization, authority and transfer details.

The existing figure is retained as a schematic; its caption explains the
Active/Standby labels and excludes any implication of immediate disposal.
Previously generated HTML does not include this source update. The Japanese PDF
was refreshed on 2026-11-13 as recorded below.

## Japanese PDF refresh — 2026-11-13

The latest manuscript was rendered through the existing `cozy pdf` Japanese
LaTeX business route: [local PDF](target/textus-cncf-security-architecture-ja.pdf),
A4, 28 pages, eight figures and six tables. All pages were visually inspected.
All 319 manuscript-backed Japanese paragraph/caption/header/table-cell values
were found in extracted PDF text, including the latest memory/state-preservation,
HA and immutable-infrastructure explanations. Five pre-existing root-level
Document explanation blocks are not projected into the current manuscript;
these are recorded separately from PDF rendering coverage.

The [existing Google Drive @Active PDF](https://drive.google.com/file/d/1G4XqdOZZtqaqcKgGRFKp_8aMY4dNNUl1/view?usp=drivesdk)
was updated in place, preserving its ID, link, folder and sharing. Readback
confirmed the PDF MIME type, destination parent and 1448368-byte size.
The previous local PDF is preserved in private generation evidence. Manuscript
and content sources, historical journals and the original publication date were
left unchanged. No HTML regeneration, runtime tests or Git commit was selected.

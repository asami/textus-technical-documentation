# Immutable Infrastructure Guide and HA Separation

Date: 2026-11-13
Status: source draft; rendering, runtime qualification and publication not performed

## Request and decision

Create a dedicated immutable-infrastructure guide alongside the existing HA
guide. Cover purpose, adoption and everyday operation as well as mechanisms.
Security retains the security argument and links to both guides. Rename the
current HA reader-facing title without changing its document identity/path.

The user emphasized CNCF's deliberate structure: improve responsiveness through
resident memory without leaving business continuity-critical state solely in a
runtime process. Explain authoritative persistence and UoW, reconstructible
caches/Views, supported durable continuations, transient execution and uncertain
outcomes separately. Planned replacement drains admitted work; crash recovery
reconciles durable outcomes and does not imply arbitrary Running-task replay.

## Sources authored

- [New guide project](../../../../src/main/smartdox/technical-guide/immutable-infrastructure/textus-cncf-immutable-infrastructure.dox/README.md): shared recursive Core, Japanese/English Documents, bilingual SmartDox, existing native local target declarations and Japanese confirmation vocabulary. Eleven chapters and six tables.
- [HA guide](../../../../src/main/smartdox/technical-guide/availability/textus-cncf-availability-architecture.dox/README.md): HA-focused title, companion reference and clearer memory/durability explanation.
- [Security guide](../../../../src/main/smartdox/technical-guide/security/textus-cncf-security-architecture.dox/README.md): current role distinctions, planned A/B/C retention, failure/compromise boundary and references.
- [Current design boundary](../../../design/availability-guide-boundary.md) and repository navigation updated.

## Outcome and limits

Static source correspondence, local links, heading termination, locale parity
and JSON/source structure are checked in this task. These checks do not execute
Cozy or validate renderer output. No HTML, PDF, diagrams, slides, video, upload,
commit, runtime test or SBT execution is selected. Previously generated Security
outputs remain older than this source revision. Phase 108 remains planned and
IR-01 through IR-05 OPEN. Storage durability and host-failure claims require
their own actual qualification. Existing and historical journals are preserved.

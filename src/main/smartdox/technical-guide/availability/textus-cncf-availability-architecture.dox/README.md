# Textus/CNCF Availability and HA Document Project

Status: architecture-first revision rendered to Japanese PDF and updated in
@Active on 2026-11-13 after the user's explicit generation request.

## Sources

- `content/core.yaml`: shared semantic identities, containment, local explanation nodes and explicit chapter flow.
- `content/ja/document.yaml`, `content/en/document.yaml`: full Japanese and English prose/tables with Core references.
- `index.dox`: bilingual SmartDox expression of those Documents.
- `build/document-project-targets.yaml`: existing native Japanese structure/reader and bilingual article HTML routes, declared for later requested use.

The current draft has eight chapters, 22 thematic subsections, 13 tables and
two diagrams per locale. Shared Core containment follows this actual hierarchy;
child-Step flow and local explanation structure remain separate relationships.
The Japanese PDF recorded below now reflects this source revision.
Core source admission is distinct from runtime HA acceptance.

## Architecture-first reading order

1. HA purpose and design goals: ordinary SME workloads, intended continuity level, responsiveness, committed data and failure boundaries.
2. Overall architecture: concern hierarchy, connected components and ordinary request paths.
3. Execution: stable entry, runtime roles and lifecycle.
4. Data/synchronization: authoritative, resident and transient state, common synchronization and durable work.
5. Control: election/Lease/fencing/readiness and separate admission/completion authority.
6. Behavior: normal service, planned switchover, failover, Read-only for failure/maintenance, retention and retirement.
7. Deployment/operation: profiles, failure domains, dependencies, observation and cost.
8. Appendix: first-delivery plan and sources.

The guide explains purpose, structure, responsibilities and relationships before
transition behavior. It is not an operator command runbook. Editable PlantUML
masters and Japanese/English PNG diagrams reside in `images/`.

The target level is described by failure/maintenance boundaries, with ordinary
SME business systems as the central workload and ordinary configuration as an
adoption goal. First delivery prioritizes local-ha planned replacement; runtime
failure handling remains a design target with automatic takeover qualified
later. Host-ha is selected when required, and AZ/site resilience remains future
scope. Configuration convenience does not replace the HA-level definition or
constitute evidence that it has already been delivered.

Read-only for failure and planned maintenance is an additional source-level design proposal: close new
business mutations while continuing only trusted, authorized and freshness-
qualified reads. It is distinct from Read Replica role and lifecycle state.
Transitioning admitted work, refusal across entry points, audit/operational
writes, permitted failure conditions and explicit recovery qualification are
explained in the guide. Entry reason and return conditions distinguish emergency
degradation from planned maintenance. Authorized maintenance actions are separate
from ordinary business mutations; any read scope made unsafe by maintenance is
unavailable. No dedicated CNCF mode, ABI or implementation is claimed;
the existing Phase 108 plan and runtime contracts are unchanged.

Memory residency is explained as a continuity mechanism as well as a performance
mechanism. CNCF aims to retain much of its business-processing data and indexes
in memory; Read-only can use known committed resident state for searches, lists
and inquiries during impaired persistence access. Qualified resident reads remain
distinct from reloads/cache misses and from reconstruction after runtime loss.
The actual retained business scope depends on resident coverage and required
authorization/audit/freshness dependencies; no measured coverage is claimed.

Residency distinguishes all valid master records from activity-scoped Working
Sets, with completed/archived history remaining store-backed. Active-user carts
and needed user/address data are examples: membership depends on current
business activity, not only the member's own state-machine transitions.
User-activity policy is defined separately from EntityKind defaults. Read-only
retention separately keeps business-read cache values through routine expiry or
scheduled purge, while preserving meaningful freshness metadata and bounded
retained scope. It does not extend security validity or suppress explicit
invalidation/deletion, committed synchronization or recovery qualification.

## Registered development plans — 2026-11-13

The source proposals now have formal CNCF work ledgers:
[Phase 123 — Activity-Scoped Entity Working Sets](../../../../../../../../dev2025/cloud-native-component-framework/docs/phase/phase-123.md)
and [Phase 124 — Read-only Operation for Failure and Maintenance](../../../../../../../../dev2025/cloud-native-component-framework/docs/phase/phase-124.md).
Both are planned, unstarted and entirely OPEN. Their first single-runtime routes
reuse existing foundations; Phase 108's acceptance and priority remain unchanged.
Registration is not implementation evidence. The PDF appendix now records these
planned deliveries, consistently in Core, Documents and manuscript.

## Design authority

- [HA design](../../../../../../../../dev2025/cloud-native-component-framework/docs/design/availability-architecture.md)
- [Runtime design](../../../../../../../../dev2025/cloud-native-component-framework/docs/design/subsystem-runtime-architecture.md)
- [Cache design](../../../../../../../../dev2025/cloud-native-component-framework/docs/design/runtime-cache-synchronization.md)
- [First delivery](../../../../../../../../dev2025/cloud-native-component-framework/docs/phase/phase-108.md)

Current roles are Primary, Read Replica, Standby and Draining Former Primary. The guide preserves the difference between Switchover and Failover and prioritizes the first operational planned-replacement route. IR-01..IR-05 remain OPEN.

Historical journals are not rewritten. Source-only authoring does not select confirmation or publication products.

## Native contract boundary

This is a direct `.dox` project using the implemented local-build contract,
locale-neutral `content/core.yaml` and localized Documents. The declared Document
targets explicitly select Japanese; the English source is maintained in parallel.
The local-build contract does not load or require `document-project.yaml`.

The first `cozy document-project inspect` attempt returned `DP-DESC-002` because
its workflow-descriptor route requires the distinct historical
`content/core-<language>.yaml` contract. The newly copied incompatible descriptor
was removed after checking that contract. No historical locale Core, second
semantic authority or renderer was added to satisfy inspection. The diagnostic
and original command evidence are retained; no command was retried.

Static Core/Document/manuscript checks do not claim native render acceptance.
No direct-project HTML target was selected or generated by this source request.

## Japanese PDF — 2026-11-13

The revised eight-chapter manuscript was rendered through the existing `cozy pdf`
Japanese LaTeX business route: [local PDF](target/textus-cncf-availability-architecture-ja.pdf),
A4, 15 pages, 441635 bytes. All pages were visually inspected; all 308 Japanese
heading, paragraph, caption, header and table-cell values are present in extracted
PDF text after normalizing link labels, page footers and discretionary hyphenation.

[Google Drive @Active copy](https://drive.google.com/file/d/1mP-b8DXSqPZHe0gMOAoJ3VtnZqIYM-2i/view?usp=drivesdk).
Connector metadata readback confirmed the same file ID, destination folder and
441635-byte size. Existing sharing and the viewing link were preserved.
This request generated no HTML, changed no runtime and performed no Git commit.

### Currentness after structural feedback

The 2026-11-13 explicit regeneration request superseded the earlier comment-round
deferral. The local PDF and its existing Drive copy now contain the architecture-first
revision, Read-only failure/maintenance proposal, activity-scoped Working Set and
cache-retention explanation, and planned Phase 123/124 appendix. The earlier PDF
is retained in private evidence. No HTML, runtime test or Git commit was selected.

## Companion guide — 2026-11-13

Adoption, everyday immutable-infrastructure operation, security motivation and
cost/effect now have a [dedicated guide](../../immutable-infrastructure/textus-cncf-immutable-infrastructure.dox/README.md).
This guide retains the HA mechanics and its stable document identity/path.
Memory responsiveness depends on reconstructible resident state and authoritative
durable outcomes, not continuity-critical state held only in one process.

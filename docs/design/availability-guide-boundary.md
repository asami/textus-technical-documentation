# Availability Guide Boundary

Date: 2026-11-12
Status: initial document design; runtime implementation and publication are separate

## Purpose and authority

The [Availability and HA guide](../../src/main/smartdox/technical-guide/availability/textus-cncf-availability-architecture.dox/README.md)
explains the intended Textus HA model and the first practical immutable-runtime
delivery. CNCF owns runtime semantics and implementation planning. This Document
Project owns their reader-facing explanation, not a second HA runtime contract.

The source authorities are CNCF Availability Architecture, Subsystem Runtime
Architecture, Runtime Cache Synchronization and Phase 108. Their current
distinctions must remain visible in shared Core and both localized Documents.
The manuscript is derived from those Documents; rendered products are projections.

## Required explanation boundaries

- Primary owns new mutation admission; Read Replica serves permitted reads;
  Standby is promotion readiness; Draining Former Primary completes scoped old work.
- Planned Switchover transfers admission before old updates finish, under
  qualified scoped completion authority. It includes A's late commits in cache
  synchronization and retains a current fallback until all retirement conditions hold.
- Unplanned Failover requires valid takeover ownership, fencing and readiness.
  It does not wait for unreachable-node drain or blindly replay uncertain work.
- Cache synchronization handles multiple members, committed changes, source
  order/versions, deletion/invalidation/purge, applied progress and baseline/delta
  catch-up. Cache progress is neither leader ownership nor business-data durability.
- Established election/lease/fencing integration is selected by its actual
  deployment contract; etcd is a candidate, not an installed dependency claim.
- First delivery prioritizes operational planned replacement, scheduled rotation
  and compatible selected-CAR change, with authority-loss safety. Broad automatic
  Failover and expanded topology are later delivery; they do not gate the first
  practical route or become implemented by authoring this guide.

Historical journals remain unchanged. Record each subsequent decision in a new
journal and update the current design/notes and the affected content authorities.
Existing runtime enum/API/configuration names are not renamed through prose.

## Source-only delivery

The first draft contains 11 chapters and six tables with a locale-neutral
recursive Core and Japanese/English Document sources. The direct `.dox` project
declares Japanese inputs for Document targets and retains English in parallel.
Local confirmation targets
follow existing native project conventions but were not selected for rendering.
Source inspection/structural checks, rendering, human review, publication and
runtime acceptance are separate outcomes. HTML, PDF, slides, video and upload
are not implied by this manuscript-authoring request.

Use the supported direct local-build contract without a workflow descriptor.
The older `inspect` workflow route requires a different locale-specific Core
contract and is not the source-admission route for this recursive shared Core.
Do not create a second Core or rename the shared authority to make that route
appear compatible. Retain a failed diagnostic as history and distinguish static
source checks from later requested native product rendering.

## Guide separation — 2026-11-13

The [Immutable Infrastructure guide](../../src/main/smartdox/technical-guide/immutable-infrastructure/textus-cncf-immutable-infrastructure.dox/README.md)
owns adoption rationale and operation: why/where replacement is useful, routine
rotation, compatible updates, retention/switch-back, exceptions and cost/effect.
This existing HA guide keeps continuity, cache synchronization, role/authority
and Switchover/Failover details under its unchanged document identity. Security
explains the protection benefits and limits and links to both guides.

CNCF intentionally uses memory for responsiveness without leaving business
continuity-critical state solely in process memory. Authoritative committed
state, reconstructible resident state, supported durable continuations and
transient/uncertain work must be distinguished. Memory residency or replica
notification alone is not durability, and a crash does not imply arbitrary
Running-work replay. Prove the adopted storage durability and failure boundaries
with actual persistence and recovery integration. Do not claim that unfinished
Phase 108 units, host HA or complete storage-failure protection are delivered.

The new guide uses the same direct-project source contract and existing local
target declarations. Source creation does not select rendering or publication.
Record this decision in a new journal; the 2026-11-12 journal remains untouched.

## Architecture-first hierarchy — 2026-11-13

Reader feedback identified a procedure-dominated explanation with insufficient
purpose and whole-system structure. The guide now starts from HA purpose and
quality targets, then presents a concern tree and component overview. Its main
structural areas are execution, data/synchronization, control, and deployment/
operation. Normal/transition behavior follows those areas; delivery order moves
to an appendix. With the subsequent HA-level clarification, the current source
has eight chapters, 22 thematic subsections, 13 tables and two diagrams in each locale.

This is a real Core containment hierarchy, not only deeper manuscript headings.
Explicit child-Step flow remains separate from local explanation nodes. Existing
role, update, synchronization, scoped-completion, fencing and retirement meanings
and their stable source identities are retained. The diagrams distinguish logical
responsibilities from physical hosts and ordinary data paths from control paths;
they select principal relationships rather than enumerate every integration.

The user subsequently explicitly deferred PDF generation until all comments are
complete. This revision is source-only: retain the earlier local/Drive PDFs as
earlier outputs, mark them stale relative to this manuscript, and do not render
HTML/PDF or update Drive during the comment round. Record the revision in a new
journal; prior journals and CNCF runtime contracts remain unchanged.

## Intended HA level and ordinary SME workloads

Chapter 1 must define the targeted continuity level, not only how easy settings
should be. Ordinary SME business systems are the central workload, with a usable
standard configuration and realistic cost/operational burden. Classify the target
by maintenance and failure boundary: local-ha planned replacement first, runtime
failure handling with automatic takeover separately delivered/qualified,
host-ha selected when required, and AZ/site resilience as future scope. Do not
invent an availability percentage, equate first delivery with completed automatic
failover, or present ordinary settings as evidence of achieved HA. Align detailed
policy overrides with this intended standard-use model.

## Read-only proposal for failure and planned maintenance

The user requested a read-only service option for failures and planned maintenance. Add it to Chapter 1
as a proposed continuity level and Chapter 6 as service behavior. It is a
Subsystem business-service mode, independent of Read Replica role and runtime
lifecycle. Close new business mutations at shared admission/execution boundaries
across APIs, schedules, Jobs/Workflows and events; UI controls alone are not
enforcement. Preserve required authorization/audit and distinguish necessary
operational writes from forbidden business side effects.

Report transition separately while admitted valid work settles. Lost authority
does not retain completion permission; unreachable former runtimes and stale
paths require actual enforcement. Serve only trusted, authorized reads whose
freshness contract is satisfied; otherwise report unavailable for that scope.
Expose mode, reason and data progress. Define explicit operator selection and
conditions for any automatic entry; qualify authority, fencing, synchronization
and uncertain outcomes before recovery. Do not silently queue refused mutations
for later execution.

This is a newly authored design proposal. Existing CNCF design contains permitted
read-only Replica use and degraded/unavailable behavior, but does not establish
this dedicated service-mode ABI or implementation. Runtime contracts and Phase
108 are not modified by this manuscript feedback; the proposal is not an added
first-delivery acceptance gate. PDF generation and Drive update remain deferred.

Use one service mode with distinct entry reasons and recovery conditions. Failure
entry protects safe reads when mutations or takeover cannot be qualified;
maintenance entry closes business mutations before planned inspection/data work.
Explicitly authorized maintenance actions are separate from ordinary business
updates. Maintenance that makes reads unsafe makes that scope unavailable. Resume
after cause resolution or work completion plus the common authority/data/outcome
checks, never solely on a maintenance schedule. Retain source identities while
generalizing the reader-facing heading and concern diagram.

## Resident-data continuity during impaired persistence access

The user clarified that CNCF aims to keep much of its business-processing data
resident. Explain that this supports availability as well as responsiveness:
Read-only may continue searches, lists and inquiries using known committed
resident data/indexes when disk/database access is slow or unavailable. The
guide must make this intended business benefit explicit, while qualifying
actual coverage and dependencies rather than claiming measured availability.

Distinguish resident-only reads from cache misses, unbuilt indexes and operations
requiring fresh authoritative reads. Impaired storage must not cause unbounded
reload waits. Authorization, required audit and freshness still apply. After
runtime loss removes resident state, reconstruction needs an available source
or qualified replica. This does not alter persistence/durability semantics or
claim storage-independent restart. PDF and Drive updates remain deferred.

## Working Set selection and Read-only cache retention

Apply the historical classification: master data targets all valid records;
transactional data targets active Working Set members rather than all completed
history. Current `master` defaults select ResidentAll; `workflow` active residency
requires explicit state-field policy. Do not infer automatic active-state
admission merely from the word workflow.

Keep this residency policy distinct from the proposed Read-only retention policy
for business-read caches. Routine TTL expiry or scheduled purge should not alone
discard a still-usable value while persistence is impaired. Preserve freshness
deadlines and source/applied metadata and serve stale values only where allowed.
Declare retained scope and memory budget. Security/session validity, explicit
deletion/invalidation/revocation and qualified committed changes still apply.
Retained bytes do not authorize an invalidated read. Qualify source coherence
before restoring ordinary cache retention. No runtime implementation or new
cache ABI is established by this guide change.

## Activity-scoped user Working Sets

The user clarified that a Working Set includes active users' carts and needed
user data such as addresses. Explain it as the data needed for current business
activity. An address can be a member through its relationship to active work
without having its own ongoing state-machine transitions. Preserve per-user
authorization and reuse already resident master data where applicable.

Selection follows explicit business/user-activity conditions; re-evaluate
residency when activity ends while keeping authoritative persistence independent.
This extends the earlier transactional-state explanation. It does not rewrite
historical journals, reclassify profile data automatically as master/workflow,
or assert that current runtime code already applies user-activity policies.

## Development plan registration — 2026-11-13

CNCF now records activity-scoped Entity Working Sets in Phase 123 and Read-only
operation for failure/maintenance in Phase 124. Both are planned and unstarted;
all checklist items are OPEN. Single-runtime routes reuse existing residency,
persistence and authorization. Activity and cluster extensions consume qualified
producer capabilities, without adding Phase 108 acceptance gates. The guide's
source-level design is not evidence that either runtime capability is delivered.
Historical journals are preserved. The subsequent explicit PDF request is
recorded below; the registered plans remain unstarted.

## PDF refresh and @Active update — 2026-11-13

The user's explicit request to regenerate with Cozy and update @Active supersedes
the comment-round PDF deferral above. Add the Phase 123/124 planning status to the
appendix through Core, both Documents and the manuscript; preserve implementation
boundaries and all other reviewed prose. Native Cozy PDF generation and all-page
visual/text checks passed. The 15-page Japanese PDF replaces the bytes of the
existing @Active file, retaining its identity, location and sharing. This document
delivery starts no runtime work and changes no Phase acceptance condition.

## Immutable guide structure and tone — 2026-11-13

The immutable-infrastructure guide now follows purpose/scope, concepts, overall
architecture, state boundaries, lifecycle/operation, security, configuration/cost,
implementation status and references. Its source contains nine chapters, four
subsections and seven tables. The architecture chapter identifies elements,
responsibilities and construction, business-data and control connections before
replacement behavior. Application/platform ownership and durable/reconstructible/
transient state remain distinct.

Descriptive headings and neutral factual prose replace exhortations and
promotional framing in both languages. Intended design, planned implementation
and qualified behavior remain explicitly separate. Core, both Documents and the
derived SmartDox manuscript follow the same hierarchy and explanation order.
This source revision changes no CNCF contract or Phase status. The earlier
immutable-guide PDF and @Active copy remain unchanged; generation is deferred
until explicitly requested. Earlier journals remain immutable.

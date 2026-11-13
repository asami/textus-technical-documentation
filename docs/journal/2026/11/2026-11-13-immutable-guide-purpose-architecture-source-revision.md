# Immutable Infrastructure Guide — Purpose, Architecture and Neutral Prose

Date: 2026-11-13
Status: source revision only; PDF generation explicitly deferred.

## Request and adopted scope

The user requested application of the recorded structure and tone policy to the
immutable-infrastructure guide's body, without producing a PDF. The
[review note](../../../notes/immutable-infrastructure-guide-review.md) remains
the current checklist; the preceding comment journal remains unchanged.

## Source changes

The [manuscript](../../../../src/main/smartdox/technical-guide/immutable-infrastructure/textus-cncf-immutable-infrastructure.dox/index.dox)
now has nine chapters: purpose/scope, concepts, overall architecture, state
management, lifecycle/operation, security, configuration/quality/cost,
implementation status and references. Four subsections group tier/ownership and
the planned, scheduled/update/switch-back and exceptional operating cases.

The architecture chapter contains an element/responsibility/connection table
and prose for construction, service/data and control/observation paths. Definitions
and structural dependencies precede operating sequences. The seven tables include
the six earlier table identities and the new architecture table.

All existing paragraphs were revised in Japanese and English to use neutral
technical descriptions. Exhortative headings and promotional openings were
replaced with descriptive labels, definitions, conditions and implementation
status. Persistence, reconstructible residency, scoped admitted-work completion,
fencing/readiness, compromise handling and uncertain outcomes remain explicit.

Shared Core, both localized Documents and SmartDox were revised together. All
35 existing block identities and 12 existing Step identities are retained.
Two grouping Steps and eight explanation blocks were added. Recursive containment,
child-Step reading Flow and explicit local explanation chains remain distinct;
local sequence relations are authored using the existing step/next vocabulary.

## Validation and preserved outputs

Static checks cover closed source shapes, unique identities, local sequence
cardinality/endpoints, immediate-child Flow, locale correspondence, labels,
retained identities, table dimensions, manuscript values, local links, heading
termination and whitespace. They are source checks, not native Cozy admission
or renderer/runtime qualification.

Checks passed for 14 Core Steps, 43 blocks per locale, 29 local sequence
relations and 144 paired manuscript values. All retained identities resolve.
The root README's unrelated live-prototyping link was already missing in the
preserved baseline and remains unchanged; selected new and revised links resolve.

The earlier local PDF is retained at its existing path with unchanged size and
modification time. Its @Active copy is unchanged and is marked as the earlier
11-chapter version in current navigation. No PDF/HTML rendering, preview,
upload, SBT, runtime test, commit or push was selected. HA/Security manuscripts,
CNCF Phase statuses and historical journals are unchanged.

Prior sources, authoring record and validation evidence are retained under
`/private/tmp/skill.cncf.d/a-d179d439-832c-4f17-825e-bb23e203fba9/`.

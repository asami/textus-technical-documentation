# Working Set Selection and Read-only Cache Retention

Date: 2026-11-13
Status: source/design feedback incorporated; PDF and Drive deferred

## Basis and request

The user recalled the distinction between fully resident master data and active
transactional Working Sets, and proposed retaining caches in Read-only mode
instead of losing usable values through ordinary expiration or purge.

Earlier read-only investigation confirmed the distinction in CNCF's March
Entity Management Model, Memory-First Domain Architecture sections 7–8,
Entity Kind and Working Set Policy and EntityKindRuntimePolicy implementation.
`master` defaults select ResidentAll. Business `workflow` entities need an
explicit active-state policy; this is not automatically inherited by runtime
WorkflowInstance or non-stateful task entities.

## Adopted explanation

In the [HA guide](../../../../src/main/smartdox/technical-guide/availability/textus-cncf-availability-architecture.dox/index.dox),
distinguish Working Set residency from business-read cache retention. Preserve
last qualified cache values across routine TTL expiry and scheduled purge during
Read-only operation. Keep freshness deadlines/application metadata meaningful;
expired retained values are potentially stale and eligible only for permitted
reads. Declare the retained scope and memory budget.

This does not freeze authentication/session validity, ignore permission expiry,
serve explicitly invalidated/deleted data or suppress qualified committed-change
synchronization. Retained bytes do not establish read eligibility. Reconcile
required authoritative state before returning to ordinary cache retention.
The existing canonical cache synchronization semantics remain unchanged.

## Source and verification boundary

Add three Core-referenced paragraphs across resident-state structure and Read-only
behavior. Shared Core, Japanese/English Documents, SmartDox and current notes
remain synchronized; source count is 97 blocks. Earlier source bytes are retained
under `/private/tmp/skill.cncf.d/a-7f62d51a-6f6c-4973-8cda-a5594e5d4708/before-readonly-cache-retention/`.
Run the existing static hierarchy/reference/locale/manuscript checks. Historical
journals, CNCF runtime and other guides remain unchanged. No PDF/HTML, Drive
update, runtime implementation/tests, SBT, commit or push is selected.

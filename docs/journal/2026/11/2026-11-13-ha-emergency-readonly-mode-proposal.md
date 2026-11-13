# Emergency Read-only Service Mode Proposal

Date: 2026-11-13
Status: guide/design proposal; no runtime implementation or ABI claimed

## User request and source scope

The user proposed an emergency read-only mode for failures. Add it to the
[HA guide](../../../../src/main/smartdox/technical-guide/availability/textus-cncf-availability-architecture.dox/index.dox)
as a continuity target and a separate behavior subsection. Preserve the ongoing
architecture-first hierarchy and the instruction to defer PDFs until all
comments are complete. Shared Core, Japanese/English Documents, SmartDox and the
concern diagram are updated together.

## Intended meaning

- Read Replica is a runtime role; emergency Read-only is a Subsystem business-
  service mode. Neither alone grants read access or promotion/mutation authority.
- Close new business mutations across API, scheduled, Job/Workflow and event
  paths. Reject hidden business side effects in nominal reads. Required audit,
  observation and cache-management writes use separately bounded operational
  paths; read-only does not disable required security controls.
- Show transition while previously admitted valid work settles. On authority
  loss, use fencing and actual-outcome reconciliation. Do not call read-only
  established while stale paths or unreachable members can mutate without valid
  authority.
- Continue only trusted, authorized and freshness-qualified reads. Present mode,
  reason and application progress. Refuse reads whose conditions cannot be met.
- Explicit operator selection is proposed; automatic entry requires declared
  failure conditions and permitted reads. Restore normal service only after the
  cause, authority/fencing, data readiness and uncertain outcomes are resolved.
  Refused mutations are unadmitted, not silently queued for later execution.

The existing CNCF sources describe read-only Replica use and degraded or
unavailable operation but do not establish this dedicated service-mode contract.
Do not claim a new public enum/configuration, implementation or test result.
No CNCF source/design/Phase file is changed, and no acceptance gate is added to
the first planned-replacement route.

## Evidence and limits

The prior manuscript is retained under
`/private/tmp/skill.cncf.d/a-7f62d51a-6f6c-4973-8cda-a5594e5d4708/before-emergency-readonly/`.
The current hierarchy has eight chapters, 22 subsections, 91 blocks, 13 tables
and two diagrams per locale. Check Core/Document/manuscript correspondence,
references, hierarchy, locale parity, assets and whitespace. Native PlantUML
renders the two updated concern diagrams; this is not Cozy or runtime admission.
Historical journals and other guides remain unchanged. No PDF/HTML, Drive
mutation, SBT, runtime code, tests, commit or push is selected.

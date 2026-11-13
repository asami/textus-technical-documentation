# HA Guide Reorganized Around Purpose and Architecture

Date: 2026-11-13
Status: source revision; PDF generation and Drive update deferred by the user

## Feedback and scope

The user identified missing purpose and whole-system overview, and a manuscript
that read like work instructions. Rebuild the guide as a hierarchy of subject
areas. A later instruction explicitly defers PDF generation until all comments
are finished. That instruction supersedes the earlier plan to refresh the PDF
and @Active as part of this revision.

## Revised explanation

The [guide](../../../../src/main/smartdox/technical-guide/availability/textus-cncf-availability-architecture.dox/index.dox)
now has eight chapters and 20 thematic subsections:

1. Purpose and quality goals, including service continuity, responsiveness,
   committed state and failure boundaries.
2. Overall architecture: concern hierarchy, component relationships and ordinary
   request paths, with the HA/immutable-infrastructure relationship.
3. Execution structure: stable entry, Primary/Read Replica/Standby and lifecycle.
4. Data/synchronization structure: authoritative, resident and transient state,
   common synchronization and long-running work.
5. Control structure: election, Lease, fencing, readiness and separate new-work
   admission/old-work completion authority.
6. Normal service and transition behavior: switchover, failover, retention,
   switch-back and retirement after the mechanisms have been explained.
7. Deployment and operation: profiles, failure domains, dependencies, observation,
   quality and cost.
8. Appendix: open implementation plan and sources.

Shared Core now contains the actual recursive chapter/subsection hierarchy.
Japanese/English Documents and bilingual SmartDox derive from it. Existing
explanation identities and their safety meanings are preserved while reparented.
There are 79 blocks, 11 tables and two diagrams per locale. Native PlantUML
masters and PNG assets explain the concern tree and principal component links.
Their logical boxes are not physical-host boundaries or implemented-capability
evidence. Ordinary execution and control/deployment paths remain distinguishable.

## Validation and retained outputs

Check JSON structure, unique IDs, references, child flows, locale parity,
manuscript correspondence, SmartDox heading termination and local assets/links.
All four PlantUML sources render successfully and their PNGs were visually
inspected. These are source/asset checks, not native Cozy source admission or
runtime HA qualification. The shared meaning is still the CNCF design direction;
Phase 108 implementation is not advanced by this manuscript revision.

Sources before replacement and the task-local authoring record are retained at
`/private/tmp/skill.cncf.d/a-7f62d51a-6f6c-4973-8cda-a5594e5d4708/`.
Current READMEs distinguish this source from the earlier six-page Japanese PDF.
The existing local PDF and Drive copy were left untouched and are not current for
this revision. No PDF/HTML generation, browser, Drive mutation, SBT, runtime test,
commit or push was performed. Historical journals and other guides were not edited.

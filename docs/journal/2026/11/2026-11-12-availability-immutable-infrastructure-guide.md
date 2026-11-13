# Availability and Immutable Infrastructure Technical Guide

Date: 2026-11-12
Status: source draft authored; static correspondence checked; native rendering and human review pending

The user requested a technical guide and reflection of the recent HA discussion
in design and notes, while preserving earlier journals. A new direct Document
Project is located at
`src/main/smartdox/technical-guide/availability/textus-cncf-availability-architecture.dox/`.

Its 11 chapters and six tables cover immutable execution environments, Primary /
Read Replica / Standby / Draining Former Primary, established control mechanisms,
generic cache synchronization, A/B/C planned Switchover, in-flight work,
unplanned Failover, current fallback/retirement, first implementation priority,
operational evidence and sources. A shared recursive Core, complete Japanese
and English Documents and bilingual SmartDox manuscript preserve correspondence.
The guide describes intended architecture; IR-01..IR-05 remain OPEN.

The [guide boundary design](../../../design/availability-guide-boundary.md)
separates reader-facing explanation from CNCF's runtime authority. CNCF's HA
design links the guide and its new operating-model notes. The repository README
adds an availability-guide entry without replacing existing guides or historical
publication status.

## Inspection and source contract

One registered GPT-6 Luna / low `cozy_command_runner` invocation ran
`cozy document-project inspect <new-project>` with first-attempt scoped
escalation. It completed with exit 1 and `DP-DESC-002: descriptor contentCore is
invalid`; there was no timeout. The original result and logs are retained under
`/tmp/skill.cncf.d/a-11e1cba9-9931-4e7b-ba0c-31313e581166/` and the recorded
runner session is idle. No repeat command was issued.

Inspection of the owning source/specification established that this workflow
descriptor route requires historical `content/core-<language>.yaml` authority,
whereas the recursive direct-project/local-build contract uses shared
`content/core.yaml` and does not load or require a descriptor. The new descriptor
copied from another guide was removed; the shared Core was not duplicated,
renamed or converted into the historical authority. The final guide uses the
supported direct `.dox` source/target layout. This does not claim native render
acceptance or repair an upstream product.

Static checks cover closed Core shapes, unique identities, explicit Flow scope,
Document reference resolution, localized coverage, table cardinality, manuscript
prose/table correspondence, SmartDox heading blank lines and local documentation
links. These checks are narrower than Cozy rendering and human content approval.

No HTML, PDF, image, slide or video was generated; no browser, upload, publication,
commit, push, runtime source/dependency change or application test was performed.
Earlier journals and unrelated working-tree changes were preserved.

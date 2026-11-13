# One Read-only Mode for Maintenance and Failure

Date: 2026-11-13
Status: source-level design feedback incorporated; PDF/Drive deferred

The user noted that read-only service is useful for maintenance operation too.
Generalize the [HA guide](../../../../src/main/smartdox/technical-guide/availability/textus-cncf-availability-architecture.dox/index.dox)
to use one Read-only business-service mode for both emergency degradation and
planned maintenance. Preserve the stable Core/Document identities and distinguish
the entry reason and return conditions in reader-facing explanation.

For failure, continue qualified reads when safe mutations/takeover cannot be
established. For maintenance, close new business mutations and settle admitted
work before inspection or data work. Explicit administrative maintenance actions
have separate bounded authority. If maintenance makes a read scope unsafe, that
scope becomes unavailable. Resume only after resolving the cause or completing
work and qualifying authority/fencing, data readiness and admitted/uncertain
outcomes. A maintenance-window expiry alone does not resume writes.

Update shared Core, Japanese/English Documents, SmartDox, service-mode table,
concern diagram and current documentation. The source has 92 blocks; chapter,
subsection, table and figure counts remain unchanged. The prior source revision
is retained under
`/private/tmp/skill.cncf.d/a-7f62d51a-6f6c-4973-8cda-a5594e5d4708/before-maintenance-readonly/`.
Native PlantUML renders the two updated concern diagrams. Run the existing static
source checks; this is not implementation or native Cozy acceptance. Historical
journals and CNCF runtime/Phase contracts are unchanged. No PDF/HTML, Drive
mutation, SBT, runtime code/tests, commit or push is selected.

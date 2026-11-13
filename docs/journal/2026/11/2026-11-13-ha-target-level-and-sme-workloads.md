# Intended HA Level for Ordinary SME Workloads

Date: 2026-11-13
Status: source feedback incorporated; PDF and Drive update still deferred

The user clarified that the opening must state what HA level Textus intends to
provide. The central target is ordinary SME business systems usable through
ordinary settings, without requiring difficult configuration. Ease of use
supports that target; it does not replace a definition of continuity level.

Add a dedicated subsection under Chapter 1 of the
[HA guide](../../../../src/main/smartdox/technical-guide/availability/textus-cncf-availability-architecture.dox/index.dox).
State the target using the existing canonical failure/delivery boundaries:

- First operational delivery: local-ha planned replacement, aiming to continue
  ordinary business through runtime updates/replacement.
- Runtime failure handling is an architectural target; automatic failover is
  implemented and qualified after the first planned-replacement route.
- Host-failure tolerance: select host-ha when business requirements need it,
  with compatible dependency placement/availability.
- AZ/site failure: future scope, not a current standard-delivery promise or
  Phase 108 acceptance condition.

State no universal uptime percentage or unconditional zero downtime. Requirements
are chosen from business service hours, tolerated interruption, committed-data
preservation, responsiveness, cost and actual dependency contracts. The intended
standard level remains distinct from delivered and qualified capabilities.

Align the operation-policy explanation: standard use through ordinary settings,
with detailed settings as intentional overrides. Shared Core, Japanese/English
Documents and SmartDox are updated together. The current guide has eight
chapters, 21 thematic subsections, 83 blocks, 12 tables and two diagrams per
locale. Earlier journal entries remain unchanged.

The preceding source revision is preserved under
`/private/tmp/skill.cncf.d/a-7f62d51a-6f6c-4973-8cda-a5594e5d4708/before-ha-target-level/`.
Run the existing static source checks for hierarchy, bindings, locale parity,
manuscript correspondence and local links. No PDF/HTML rendering, Drive mutation,
runtime implementation, SBT, commit or push is selected. The user's explicit
instruction to finish comments before regenerating PDFs remains in force.

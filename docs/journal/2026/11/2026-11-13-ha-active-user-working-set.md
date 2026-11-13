# Active-user Working Set Examples and Meaning

Date: 2026-11-13
Status: source/design clarification; PDF and Drive deferred

The user identified an active user's cart and the user's own address as intended
Working Set members. Clarify the
[HA guide](../../../../src/main/smartdox/technical-guide/availability/textus-cncf-availability-architecture.dox/index.dox)
accordingly: membership concerns current business activity, not only an Entity
whose own state machine can still transition.

Retain all valid master data according to its classification/policy. The dynamic
Working Set may include active transactions, carts, user data and related
addresses needed by current activity. Keep authorization boundaries and reuse
resident master data where applicable. Re-evaluate residency when activity ends
without deleting authoritative data. Actual user-activity conditions/policies
need separate definition and qualification; do not claim automatic current-code
support or infer EntityKind from these examples.

Earlier March/May records are left unchanged. Update the current shared Core,
Japanese/English Documents, SmartDox and explanatory notes together. Add one
paragraph and refine the selection explanation; source count is 98 blocks.
Prior sources are retained at
`/private/tmp/skill.cncf.d/a-7f62d51a-6f6c-4973-8cda-a5594e5d4708/before-active-user-working-set/`.
Run existing static hierarchy/reference/locale/manuscript checks. No PDF/HTML,
Drive mutation, runtime implementation/tests, SBT, commit or push is selected.

# Architectural Preconditions Maintained by the Design Harness

Date: 2026-11-13
Status: source clarification only; PDF generation deferred.

The user clarified the harness effect: architectural properties must be defined
and maintained because immutable operation and CI/CD depend on them. The purpose
chapter now relates loose coupling and high cohesion to concrete replacement/
deployment-unit responsibilities, permitted dependencies, state ownership,
interfaces, compatibility and lifecycle/completion/recovery conditions.

The selected operating method relies on these conditions. Actual tests and
deployment/replacement results check whether changes preserve them. Violations
are detection/correction subjects; declaring a property in a document is not
conformance evidence. This describes continuing architectural discipline and does
not claim automatically sufficient checks or whole-design correctness.

Both purpose paragraphs were refined in Japanese/English Documents and SmartDox.
Existing Core claim/node identities and structure retain the same subjects and
are preserved. Current notes/navigation record the clarification; earlier journals
remain unchanged. Source correspondence and prior-PDF preservation checks pass.
No PDF/HTML generation, upload, runtime work or commit was selected.

The source snapshot is retained under
`/private/tmp/skill.cncf.d/a-d179d439-832c-4f17-825e-bb23e203fba9/before-architecture-preconditions/`.

# Textus/CNCF Security Architecture Handoff

Date: 2026-10-24
Status: architecture / implementation handoff

## Purpose

Security is a first-class architectural property, not an application feature added after implementation. Textus/CNCF addresses security beginning with authority, trust, execution, distribution, containment and recovery boundaries.

Malicious attacks, software defects, operator mistakes and AI misbehavior are different causes that may attempt to cross the same authority/resource boundaries.

## Core Security Harness

### CBD

Component-Based Development divides authority and blast radius. Components expose declared Operations and dependencies and should not gain authority over unrelated Domains, DataStores, filesystems, processes or networks merely because they execute inside the same system. Provided/Required contracts make cross-Component access explicit and inspectable.

### Model Driven

CML and related models represent security-relevant semantics before implementation code. Service/Operation, purpose, statefulness, exposure and capability can be projected into Scala/CNCF Containers, TypeScript Functions, API contracts, CAR metadata and deployment constraints.

The preferred path is to omit unnecessary dangerous primitives from ordinary generated code rather than depend only on coding guidelines.

### Safety Sandbox

Safety Sandbox constrains malicious/compromised code, bugs, operator mistakes, AI-generated defects and autonomous AI/tool misjudgment.

ExecutionContext, SandboxContext, Capability and ExecutionLimits bound filesystem, network, process, HTTP, DataStore and external-service authority and resource consumption.

Prompt/Skill instructions are behavioral guidance, not technical authority boundaries. AI must not be able to exercise authority absent from its admitted execution context.

### CAR

CAR turns abstract Component boundaries into immutable, inspectable distribution artifacts. Component identity, Operations, dependencies, capabilities, implementation artifacts, Subcomponents and documentation can become inputs to CAR lint, admission, CBD Review and AI review.

## Application Tier: Function First

Application Tier uses Function First / CNCF Container Fallback. CML remains ordinary Service/Operation modeling; cloud-provider concepts are not fundamental CML concepts.

Generation produces a complete CNCF Container containing all Application Operations plus lightweight Function realizations containing only function-eligible Operations. Function candidacy and provider deployment eligibility remain separate.

The initial Function target is TypeScript. One provider-neutral common core is generated and thin Local/Test, AWS and Google adapters bind it to each environment.

Common TypeScript is maintained once, but packaging copies it into each self-contained platform Function Subcomponent CAR with its adapter and deployment metadata. No separate common-function CAR is introduced merely for deduplication.

## Local Function Testing

Local/Test is a first-class Function adapter, not a cloud emulator.

Testing progresses through common TypeScript core tests, Local Adapter boundary tests, Function-to-local-Domain integration, Active/Standby/cache integration where relevant, bounded provider adapter contract tests, and a small real-cloud acceptance set.

Where Container and Function realizations expose the same logical Operation, executable specifications should detect externally observable semantic drift.

## Function as Security and Availability Boundary

Cloud Function is also a scalable boundary between hostile/untrusted external traffic and bounded User Management/Domain resources.

The preferred cheap-to-expensive order is provider edge/WAF/rate/bot controls, request validation, obvious credential rejection, Function admission, identity resolution, Domain authorization, then Domain Operation.

Function autoscaling must not imply unbounded downstream concurrency. Admission/backpressure protects User Management and Domain capacity.

## Central User Management and AuthHandle

User Management is currently centralized. External OAuth/OIDC identity is resolved through this boundary into Textus internal identity/security state.

Application Functions do not construct authoritative SecurityContext or ExecutionContext values directly from external claims.

Normal flow:

external credential -> Function cheap pre-admission -> User Management -> opaque AuthHandle -> Function orchestration -> Domain Function API + AuthHandle -> Domain AuthHandle resolution -> SecurityContext / ExecutionContext -> Capability / Guard -> ordinary Operation.

AuthHandle is an opaque bounded-lifetime reference. It is not UserId, OAuth token, role/capability list, SecurityContext or serialized ExecutionContext.

One Application Operation may reuse the same valid AuthHandle while orchestrating multiple Domains. Authentication/User identity is system-wide; authorization remains Domain-local.

## AuthHandle Caching

The standard initial cache is Function instance-local bounded TTL memory from credential fingerprint/evidence identity to AuthHandle.

It is disposable, non-persistent, not shared across Function instances and not authorization authority. A miss calls User Management.

User Management itself uses memory/cache before User DB access.

Normal path:

Function instance memory cache -> User Management memory/cache -> User DB.

Redis or another external shared cache is not part of the standard architecture. It duplicates existing memory caches and adds network, consistency, operational and security complexity. Reconsider it only if measured scalability requirements demonstrate a real need.

## Domain Function API

The Domain Function API is a trust-boundary adapter. It receives Operation request, AuthHandle, Function/service identity and required observability context.

It resolves AuthHandle, constructs authoritative SecurityContext and ExecutionContext, applies Capability/Guard authorization and invokes the ordinary CNCF Operation path. Business Operations remain unaware of Function-specific authentication transport.

## Capability, Guard and ExecutionContext

Authentication determines identity; authorization determines permitted action.

Capability expresses admitted authority. Guard/policy evaluates subject, Operation, Entity/resource, relationship, attributes and environment. RBAC, ACL/DAC, ABAC and ReBAC are evaluation patterns/inputs.

ExecutionContext carries runtime-controlled security, sandbox, resource-limit and observability context rather than requiring business handlers to manually pass authority facts.

## Safe-by-Construction Application Security

Common vulnerabilities should be prevented by ordinary framework paths before relying on lint/review.

Examples include typed Repository/DataStore access instead of SQL concatenation, output-context-aware rendering and explicit trusted markup, Operation-derived HTTP mutation semantics and ingress CSRF policy, and declared Operation input models rather than direct Entity mass assignment.

Dangerous operations such as raw SQL, raw HTML, direct filesystem/network/process access and unsafe deserialization are explicit escape hatches visible to lint/review.

## Sensitive Information

Textus distinguishes ordinary Domain values from Sensitive Personal Data, Sensitive Identity, Credential, Secret, excluded highly sensitive values and external Sensitive Reference/Result.

External provider identity normally maps to internal Textus Subject/User identity. Where possible, high-value interactions are delegated to provider/OS including UI. Textus retains the business reference/assertion/result rather than the provider secret.

## Immutable Domain Runtime

Domain Tier supports 1 Active + n Standby/Cache. Active owns authoritative mutation; Standbys serve read-only query/cache traffic and remain promotion-capable.

Runtime artifacts are immutable and instances are regularly replaced/rotated. Daily rotation is a supported model. A replacement can start, pass admission, warm caches, serve real read traffic, prove readiness, become Active, drain the previous Active and allow the old instance to be destroyed.

This continuously exercises recovery paths.

## Replace Rather Than Prove Clean

CNCF avoids speculative custom integrity machinery without an independently justified threat requirement.

Generic defensive instinct should not introduce repeated whole-artifact hash comparisons, double reads, full working-tree copies, speculative corruption detectors or large bespoke rollback/integrity systems.

Preferred pattern:

limit authority -> observe -> detect -> contain/revoke -> replace immutable runtime -> recover from authoritative persistent state.

Published/distributed artifact integrity remains valid where the distribution threat model requires it.

## CAR Lint, CBD Review and Admission

Deterministic/static violations belong in CAR lint. Semantic/design judgments belong in CBD Review. Not every concern should become a giant lint rule set or AI prompt.

Compilation success, tests, AI review or artifact publication do not independently grant runtime authority. Admission consumes required contracts/evidence before activation.

## AI Development Security

AI-generated output enters through the same security/engineering boundary as human-written output. Authorship is not assurance.

sm-workflow manages workflow/evidence progression. CAR lint and CBD Review provide external feedback. AI self-assessment is not independent security evidence.

AI over-defense is itself a quality/security concern. Unnecessary hashes, duplicate reads, rollback machinery and speculative integrity logic increase complexity and may create defects or false assurance.

Human-in-the-loop remains important for high-authority actions, exceptions and important admission/release decisions.

## Observability, Containment and Recovery

Security architecture includes detection and recovery, not only prevention.

Security-relevant runtime/Operation/authorization/subsystem/infrastructure signals use the normal observability route including OTLP and can be composed by Control Center.

Credentials, tokens and unnecessary personal information must not become logging/tracing payload.

Incident response prefers authority revocation, traffic isolation, immutable runtime replacement and recovery from authoritative state over attempting to prove an arbitrary running instance clean.

## Security Lifecycle

1. Prevent — safe-by-construction, Function First, sensitive interaction delegation.
2. Constrain — CBD, Capability, Sandbox, least authority.
3. Verify — Model, CAR, lint, review, admission.
4. Observe — OTLP, runtime/security evidence, Control Center.
5. Contain — trust boundaries, blast-radius control, rate/admission, authority revocation.
6. Recover — Active/Standby, immutable replacement, authoritative-state reconstruction.

## Technical Documentation Distribution

Security documentation is developed in this repository as a dedicated Textus Document Component.

- docs/ is internal design/notes/journal/phase material.
- product documentation lives under src/main/.
- SmartDox is the intended semantic source of truth.
- publication is multilingual and multi-format.
- normal CAR distribution includes Web/MCP/AI-consumable forms and PDF.
- PDF is included by default for direct human/email distribution.
- all formats derive from the same logical Document revision.

The first product document is src/main/smartdox/security/textus-cncf-security-architecture.md.

## Existing specification/development connections

CNCF:
- docs/design/textus-security-architecture.md
- docs/notes/sensitive-information-architecture.md
- docs/journal/2026/04/execution-context-securitycontext-session-integration-note.md
- Phase 75: Function candidacy handoff
- Phase 92: Platform Function Subcomponent CAR distribution
- docs/journal/2026/10/2026-10-24-function-auth-handle-boundary.md

Cozy:
- Phase 87: Application Function Subcomponent generation
- P87-06: AuthHandle-aware Function security generation
- Local/AWS/Google adapters share one Function ABI
- common TypeScript is shared at source/build level and copied into platform CARs at packaging time

Textus Technical Documentation:
- Phase 1: SmartDox multilingual/multi-format build, Documentation CAR, MCP information surface and PDF publication
- Security Technical Guide is the initial reference document

## Continuing work

The four core Security Harness mechanisms are not exhaustive. As additional CNCF mechanisms are recognized as security-relevant, add them to the Technical Guide and, where appropriate, canonical security architecture.

Already identified mechanisms include Tier Architecture, Function First, Capability/Guard, ExecutionContext, AuthHandle, Safe-by-Construction APIs, Sensitive Information Architecture, UnitOfWork boundaries, Explicit Escape Hatches, immutable Active/Standby runtime, CAR lint/CBD Review/admission, observability/Control Center, Human-in-the-loop and replace-rather-than-prove-clean operation.

The Technical Guide is a living document rather than a one-time security whitepaper.

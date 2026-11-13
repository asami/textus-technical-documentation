# Security Guide Document Project and Journal Expansion

Date: 2026-10-24

## Request and authority

Convert the security guide to a Document Project, produce a logic-tree confirmation view, and enrich the article from related journal material. Japanese and English remain supported from the preceding request.

Primary expansion source: [Security Architecture Handoff](2026-10-24-security-architecture-handoff.md). The initial Document Component direction and multilingual migration record supply the publication/source boundaries. The handoff records architecture decisions; its references to CNCF and Cozy phases are not independently promoted here into implementation-status claims.

## Source and project layout

`src/main/smartdox/security/textus-cncf-security-architecture.dox/` is now a direct Document Project. The preceding bilingual file is preserved in `docs/notes/security/textus-cncf-security-architecture-bilingual-initial.dox`.

- Shared Core: `content/core.yaml`, `cozy.content-core.logic-tree.v1`.
- Localized prose: `content/ja/document.yaml` and `content/en/document.yaml`, `cozy.document-description.v2`.
- Derived bilingual article: `index.dox`.
- Project descriptor: `document-project.yaml`, `cozy.document-project.v2`.
- Native targets: `build/document-project-targets.yaml`, `cozy.document-project.local-build-targets.v1`.
- Selected confirmation locale/product: Japanese / `document-structure-html`.

Seven groups organize 25 leaf sections. Core contains 33 Steps with separate containment, direct-child Flow, and local Structure. Mechanism/result dependencies use `depends-on`; processing sequences use `next`. Prose carries explicit references rather than inferring relationships from wording or order.

## Journal additions

- Function candidacy versus provider deployment eligibility, with a complete Container fallback.
- One common TypeScript core, shared Function ABI, and self-contained platform Function Subcomponent CARs.
- Local/Test as a first-class adapter; staged tests and semantic agreement between Container and Function realizations.
- Cheap-to-expensive ingress checks, downstream admission and backpressure.
- Bounded-lifetime AuthHandles, instance-local caches, User Management memory/cache, and the reason to avoid an unneeded shared Redis cache.
- Domain Function API as a trust-boundary adapter that constructs authoritative contexts and invokes normal Operations.
- Context-aware rendering, CSRF policy, declared input binding, unsafe deserialization as an explicit escape hatch, and sensitive-information classifications/provider or OS delegation.
- Active/Standby readiness, warm-up, promotion, drain and replacement; containment/revocation/recovery rather than speculative integrity machinery. Distribution integrity remains appropriate under its own threat model.
- Build/test/review/publication success distinguished from runtime authority.

## Selected dependency closure

1. Author shared Core from the existing guide and the handoff.
2. Author both localized Documents with complete Core references and wording labels.
3. Derive bilingual `index.dox` from those Documents.
4. Reuse the established Japanese confirmation vocabulary; declare all three native target entries as required by the closed local-build catalog.
5. Render only the requested Japanese `document-structure-html` target, using Core, Japanese Document, vocabulary, and target configuration.

The reader and actual-article HTML targets are declared but not selected. No PDF, slides, video, publication, deployment, or CAR release is selected. `target/` and local command-session evidence are excluded from Git.

## Validation

Source checks preserve all prior body paragraphs and list/matrix content, cover all 18 original sections, and establish complete bilingual identity/label correspondence. Native confirmation validation and generation are recorded after execution below.

### Native build and confirmation

The native Cozy `document-project build` for `document-structure-html` completed successfully (exit 0, empty stderr). Output: `src/main/smartdox/security/textus-cncf-security-architecture.dox/target/document-project/local-build/document-structure-html/index.html`.

Execution used the registered `cozy_command_runner` role, GPT-6 Luna / low, agent `/root/security_document_project_renderer`. Execution identity: `d3b8332bcc7ee799177bf9e543e76b70`.

A loopback-only, verification-only browser preview confirmed the Japanese tree, local structure, and prose. Selecting `auth-cache` switched the displayed structure to the cache-resolution sequence and scrolled to and highlighted the matching prose. The view reported accepted inputs and no unresolved references. These are document consistency results, not a security-strength assessment or release acceptance. English source correspondence was checked; an English confirmation HTML was not selected for rendering.

## Architecture-flow revision

The user accepted the review of the logic tree and asked to reflect it in the project. The guide is reorganized around how controls cooperate, rather than a sequence of technology descriptions.

The seven groups now cover: the overall architecture; external-request admission; identity through authorized execution; defects and disclosure in authorized processing; generation/distribution/deployment; incident containment and recovery; and threat/control correspondence.

- The opening connects CBD boundary design, model contracts, CAR inspection and admission, runtime authorization/Sandbox, and operational recovery.
- Function packaging and Local/Test details move after the uninterrupted runtime request path. AuthHandle caching follows the identity, Domain authorization, context, and Sandbox explanation.
- Each group explains the problem, cooperating mechanisms, resulting effect, and the remaining scope handled by another control. Local Structures describe these explicit explanation steps; child-Step Flow remains the authored reading order. Neither ordering implies that the mere presence of a control guarantees an outcome.
- Technical sections connect declared contracts to enforcement, distinguish permitted operations from unlimited resource use, and connect ordinary implementation paths and escape-hatch inspection to Sandbox constraints.
- Operations begin with observation and incident assessment. Immutable artifacts, Active/Standby readiness, rotation, replacement, and business recovery have separate responsibilities. Runtime replacement does not undo past disclosure or invalid persistent updates.
- The threat mapping retains twelve cases and now states combined behavior and assumptions/limits, including input constraints versus overload admission and artifact checks versus runtime authority.

All existing Step identities are retained while their containment, reading order, and local explanations are revised. Unchanged prose retains its claim identities; new explanations have explicit new claims and node labels. Japanese and English Documents and the derived bilingual SmartDox article are maintained together. The established native Japanese document-structure-html route is selected; PDF, publication, and security-strength verification are outside this revision.

Local revision evidence location: `asamiair:/Users/asami/backup/journal/2026/10/textus-technical-documentation/01a0e3d8-ee8e-78f2-9bf9-b52550602726/a8bce4fa675690d7038b1dec5db3f407`. Retention date: 2026-11-23. Reusable command-session records remain at their bound local locations.

## Authentication, authorization, and Repository distribution expansion

The user explicitly requested stronger authentication/authorization explanations and the Component Repository signature/assessment/distribution model in Core and both localized Documents, together with regenerated Japanese logic-tree HTML.

Authentication now starts with human, service, and subsystem subjects and the responsibility split between CNCF and subject-specific providers. External federation is described through verification, explicit provider/subject account links, and internal sessions. Provider availability is distinguished from the architectural contract.

Authorization explains effective and required Capabilities, object-local Permission, contextual Guards, and normalized SecuritySubject. Operation invocation and UnitOfWork Entity/resource access are separate checkpoints. The chapter covers creation versus existing objects, search/list visibility, declared service/system modes, and the common context connecting authorization to Sandbox. AuthHandle and cache handling follow from this model rather than standing in for authentication and authorization themselves.

Distribution explains CAR lint and CBD Review as content assessment, signatures as publisher/content verification, and Component Repository as the distribution model connecting assessed versions, publishers, artifacts, and assessment references. The signed-use model retains the adopted optional-signature retrieval contract: unsigned is distinct from signature-verified, and a present signature's failure cannot become unsigned acceptance. Trusted namespace-authorized publisher keys, exact downloaded-artifact cache admission, local authority admission, dependencies, and update information connect distribution to runtime constraints. This authored model does not assert implementation completion of planned distribution verification or invent an implemented assessment-attestation wire format.

Sources consulted:

- CNCF `docs/design/authorization-concepts.md`, `operation-authorization-model.md`, `entity-authorization-model.md`, and `textus-security-architecture.md`.
- CNCF `docs/journal/2026/04/execution-context-securitycontext-session-integration-note.md` and `unitofwork-authorization-chokepoint-note.md`.
- textus-user-account `docs/design/external-federation-security-integration.md` and `docs/spec/external-federation-authentication.md`.
- Cozy `docs/spec/car-distribution-verification.md` (adopted planned contract, explicitly not implemented).
- CNCF `docs/notes/car-distribution-verification.md`, `docs/journal/2026/10/2026-10-09-car-distribution-verification-plan.md`, and `docs/design/car-security-metadata.md`.

The seven-group organization is retained. Six new technical sections bring the article to 31 leaf sections. Existing sections for AuthHandle, Domain ingress, and ExecutionContext are rewritten around the strengthened model. The overview, chapter explanations, threat mapping, and conclusion are synchronized in Japanese and English.

Local evidence location for this expansion: `asamiair:/Users/asami/backup/journal/2026/10/textus-technical-documentation/01a0e3d8-ee8e-78f2-9bf9-b52550602726/24dcb7855d34b573c3235f91c249047f`. Retention date: 2026-11-23. Bound reusable-session records remain in place.

## Standard-path developer and operator benefit

The user emphasized that standard configuration and modeling should let developers build and operate security-aware applications without repeatedly implementing security mechanisms themselves. The lead, opening explanation, normal-API chapter, and conclusion now make that benefit explicit in Japanese and English. Core includes the shared claims and their explanation nodes.

CBD and model-driven development have an initial learning cost. The benefit is reuse of shared checks, enforcement points, components, and operational paths, reducing custom security work and omissions compared with individually assembling controls in a flat application. The article explains the mechanism supporting more consistent application rather than inventing measured cost or security-strength comparisons. Business permissions and authentication choices remain model/configuration inputs. This is a source-only wording/meaning revision; confirmation HTML has not been regenerated for it.

## 2026-10-30 — Component independence and shared security mechanisms

The security guide now explains the combined benefit of CBD boundaries and shared authentication/authorization mechanisms. Component responsibilities, internal data, exposed operations, dependencies, and policy remain distinct. Authenticated-subject representation, authorization evaluation, execution context, and audit/observability paths are shared. Each Component/Domain applies its own required authority and business conditions; authentication or authorization elsewhere does not grant access implicitly.

The comparison with separately integrated component systems concerns the additional work needed when authentication-state transfer and authorization integration differ between components. It does not claim that earlier technologies could never share these mechanisms. Common state and decision paths support revocation and cross-component observation, making system-wide operation compatible with compartment independence.

The accepted review is reflected in the shared Core, Japanese and English Documents, and derived SmartDox article:

- Add explicit mapping from Component contracts to CAR inspection, Operation/UnitOfWork enforcement, and deployment authority/isolation. Component boundaries are not assumed to map one-to-one to processes or containers.
- Move distribution, signature verification, and destination admission into a chapter immediately after development-time inspection and before runtime protection.
- Add a shared-security section before authentication details. Common mechanisms evaluate local policy rather than merging authority across components.
- Connect component authority/dependencies and deployment configuration to shared observation and incident containment/replacement.
- Condense repeated introductions, standard-path explanations, implementation details, and Active/Standby explanations. The lifecycle describes cooperating controls and their effects, and the conclusion recovers independence, consistent enforcement, and reduced integration burden.

Existing distinctions between architecture, available mechanisms, and planned distribution verification are retained. This revision selects the declared Japanese document-structure-html target. PDF generation, Drive replacement, and publication are not selected.

The requested Japanese logic-tree HTML has been regenerated from the revised sources. The new boundary-mapping and shared-security sections and the revised node labels are included. Local evidence archive: /Users/asami/backup/journal/2026/10/textus-technical-documentation/01a0e3d8-ee8e-78f2-9bf9-b52550602726/security-composition-20261030. Retain through 2026-11-29; no automatic deletion.

## 2026-10-30 — Presentation technology independence and tiered protection

The user clarified that the Presentation tier may use TypeScript/Node.js, Flutter, or other technologies and may not use Textus security mechanisms directly. The security architecture therefore does not depend on client-side validation or UI operation restrictions. Presentation is also called the UI tier in the existing diagrams.

Core and Japanese/English prose now connect five explicit explanation points: tier responsibilities; a Zero Trust boundary for independently implemented Presentation; Application-side request and authentication-information verification plus bounded Domain API access; authorization, business rules, target-Entity access, and Sandbox restrictions inside Domain; and the combined effect on system-wide security. Application admission does not grant Domain permission, and execution inside Domain does not grant unrestricted authority.

The lead, overall architecture, Component-to-deployment mapping, external-request chapter, three-tier section, Domain ingress explanation, conclusion, and logic-tree labels are synchronized. Shared Textus authentication/authorization remains compatible with component-specific policy; it is not assumed to be a library available in every external UI. This describes an architectural protection path, retaining existing implementation-status distinctions.

The selected output is the existing Japanese document-structure-html target.

The Japanese logic-tree HTML has been regenerated with the tier premise, individual responsibilities, Domain-internal controls, and their combined effect. Local evidence archive: /Users/asami/backup/journal/2026/10/textus-technical-documentation/01a0e3d8-ee8e-78f2-9bf9-b52550602726/security-presentation-20261030. Retain through 2026-11-29; no automatic deletion.

## 2026-10-30 — Cloud Function First and cooperating tier boundaries

The accepted explanation now connects compartment structure, controls when crossing compartments, and controls within compartments. Tier responsibilities and common component-security mechanisms jointly support system-wide security: Presentation is not implicitly trusted; Application adopts Cloud Function First and limits functionality, authority, and reachable resources; Domain authorizes public operations and target data, applies business rules, and limits resource use internally. Moving inward does not automatically expand permission.

Core explicitly represents the combined tier effect as depending on the tier responsibilities and controls, with a dedicated Cloud Function First claim. Japanese and English prose, the CBD connection, Application and Cloud Function explanations, conclusion, and tree labels are synchronized. The existing distinction between function lifetime and invocation lifetime is retained; the security benefit depends on constrained authority, connectivity, and the runtime's isolation/reuse/disposal policy rather than the Cloud Function name alone.

The selected Japanese logic-tree HTML has been regenerated with the Cloud Function First claim and explicit dependencies for the combined tier effect. Local evidence archive: /Users/asami/backup/journal/2026/10/textus-technical-documentation/01a0e3d8-ee8e-78f2-9bf9-b52550602726/security-tier-cooperation-20261030. Retain through 2026-11-29; no automatic deletion.

## 2026-10-30 — Baseline protection, SimpleEntity, and precise authorization

Core, Japanese/English Documents, and the bilingual SmartDox article now explain baseline protection through standard paths and default definitions before introducing application-specific authorization. Business Entity creation defaults give owners read/write rights, with execute and group/other rights disabled; public-read profiles are explicit. SimpleEntity supplies consistent ownership, group, permission, lifecycle, publication, and audit information. Authentication providers establish identity; Entity metadata supplies target-side decision inputs. Canonical persisted metadata supports decisions when projections omit those fields.

The authorization table covers RBAC, DAC/Permission, ReBAC, ABAC/Guard, Capability scope, and execution-mode conditions. Model and configuration definitions specialize targets, operations, and conditions without rebuilding the common mechanisms. Grants and mandatory Guards remain distinct; relationship and owner/group grant paths must both match the intended policy. Service/System modes and arbitrary ACL extensions are distinguished from normal user authorization.

The overall review also condenses overlapping CBD/common-mechanism and external-request/tier explanations, moves Domain admission after authentication-state transfer, and separates server API protection from output protection in independently implemented Presentation technologies. The flow connects component independence, tier boundaries, Cloud Function First, and Domain-internal enforcement.

Technical grounding: cloud-native-component-framework docs/design/entity-authorization-model.md, authorization-concepts.md, and operation-authorization-model.md; simplemodeling-model SimpleEntity.scala, SimpleObject.scala, and value/SecurityAttributes.scala. The selected generated output is the Japanese document-structure-html target.

The Japanese logic-tree HTML has been regenerated successfully. Bilingual structure/reference checks and generated section coverage were confirmed. Local evidence archive: /Users/asami/backup/journal/2026/10/textus-technical-documentation/01a0e3d8-ee8e-78f2-9bf9-b52550602726/security-authorization-20261030. Retain through 2026-11-29; no automatic deletion.

## 2026-10-30 — Security, observability, and automatic audit trails

Core and both localized Documents now connect common execution checkpoints to automatic audit-trail collection, operational audits, impact investigation, and containment. SimpleEntity creation/update identities and timestamps complement execution records; they are not presented as a complete mutation history by themselves. Observability diagnoses behavior, while audit examines primary facts such as Events. Retention and read permissions follow the audit purpose, and records are correlated without duplicating credentials or unnecessary personal data. The bilingual SmartDox article and conclusion are synchronized.

Grounding: CNCF docs/design/execution-model.md, web-operation-dispatcher.md, simpleentity-storage-shape-policy.md, and the DslChokepoint and EntityConditionalTransitionObservation implementations. Existing implementation/status distinctions remain.

Japanese logic-tree HTML generation succeeded; source references, bilingual correspondence, output content and freshness were checked. Local evidence archive: /Users/asami/backup/journal/2026/10/textus-technical-documentation/01a0e3d8-ee8e-78f2-9bf9-b52550602726/security-audit-20261030. Retain through 2026-11-29; no automatic deletion.

## 2026-10-30 — CML and standard operation apply common security automatically

The introduction and developer-facing explanation now state that defining models in CML and running them through standard Textus configuration and execution paths automatically applies common authentication and authorization mechanisms. The explanation connects authenticated-subject propagation to Operation-entry and target-data checks using defaults or model/configuration rules. Developers select authentication methods and business-specific permissions instead of adding enforcement code to each handler. Core includes an explicit claim; Japanese and English Documents and the derived SmartDox article are synchronized.

This is a source-only revision. Source references and bilingual structure were checked; confirmation HTML was not regenerated for this edit.

## 2026-10-30 — UNIX-style Entity permissions as the authorization foundation

The developer-facing explanation and SimpleEntity section now identify UNIX-style owner/group/other read/write permissions as the concrete baseline mechanism. Standard creation supplies ownership and permissions; shared runtime paths evaluate them on reads and updates. Authentication establishes the subject, which is connected to target-side permission checks. The permission model is not described as establishing identity by itself.

This baseline is followed by richer authorization through roles, relationships, attributes, and state conditions, using the existing shared metadata and enforcement paths. Business defaults and explicit public-read profiles remain described. Core, Japanese/English Documents, and the derived article are synchronized; bilingual references were checked. This source-only edit does not regenerate confirmation HTML.

## 2026-10-30 — Usable defaults and guided security operation patterns

The guide now includes a planned provision of security operation patterns, matching profiles, and design/operation guides before the conclusion. Defaults prioritize straightforward adoption and daily operation, especially for beginners, while retaining baseline protection. Stronger configurations should be reachable with a small number of settings.

Patterns describe intended use, protected assets, combined controls, effects and operational burden; profiles align their settings; guides cover selection, business permissions, deployment, allow/deny verification, audit, revocation and recovery. Capability Profile and Security Profile connect to CML-based business authorization. Candidate use cases are illustrative, not released profile names or claims of completed delivery. Core, Japanese/English Documents and the derived article are synchronized. Bilingual references and Core child-flow endpoints were checked. This source-only revision does not regenerate confirmation HTML.

## 2026-10-30 — Integrated review and architecture-oriented figures

The full guide has been reconciled around standard-path protection, business-specific authorization, audit/observability, and selected deployment/operational hardening. The opening distinguishes lifecycle coverage from universally enabled or completed features. CML direct execution and Cozy generation have distinct roles. UNIX-style Entity defaults are explained once in detail and scoped to user-permission paths; service/framework modes remain explicit. Authentication explanation now proceeds from identity to provider verification to shared internal state.

Audit facts, diagnostic observations, and Entity creation/update metadata have distinct roles and are correlated for audit and incident response. HA and periodic rotation are deployment/operation choices; proposed daily rotation is not a default frequency. Repeated introductions and explanations have been condensed, and the conclusion recovers common mechanisms, ordinary-operation benefits, and planned guided hardening.

Both locales now contain eight figures and six tables. Added architecture-oriented figures show standard protection through selected hardening and the execution-to-observation/audit-to-response structure. The authorization figure was refreshed with policy inputs and recorded outcomes. Added tables cover tier responsibilities, business-Entity permission defaults, diagnostic/audit information, and planned patterns/profiles/guides. Editable SVGs and PNGs are product assets.

Core relationships, child flows, bilingual source correspondence, table dimensions, and figure references were checked. Six new/updated localized diagram images were visually inspected. This source-and-figure revision does not regenerate HTML or PDF.

Local source/validation archive: /Users/asami/backup/journal/2026/10/textus-technical-documentation/01a0e3d8-ee8e-78f2-9bf9-b52550602726/security-integrated-20261030. Retain through 2026-11-29; no automatic deletion.

## 2026-10-30 — Japanese PDF and @Active replacement

The integrated Japanese guide was generated through the existing Cozy LaTeX route: 26 pages, 8 figures, 6 tables. All page layouts were inspected, with detailed checks of the new overview, audit architecture, and final guidance table. Source freshness and output identity were confirmed. Google Drive @Active file 1G4XqdOZZtqaqcKgGRFKp_8aMY4dNNUl1 was replaced in place, preserving its link and parent folder (1,442,456 bytes). Confirmation HTML was not regenerated.

Local source/PDF/evidence archive: /Users/asami/backup/journal/2026/10/textus-technical-documentation/01a0e3d8-ee8e-78f2-9bf9-b52550602726/security-pdf-active-20261030. Retain through 2026-11-29; no automatic deletion.

# DDD Modeling Technical Guide — Review Comments

Date: 2026-11-13
Status: comment round closed by the user on 2026-11-13; source revision applied,
Japanese Cozy PDF generation, all-page checks and existing @Active update complete.

Target: [DDD modeling technical guide](../../src/main/smartdox/technical-guide/ddd/textus-cncf-ddd-architecture.dox/index.dox).

## Review boundary

The user initially requested comment collection without source/render changes.
The later explicit request closes that round and authorizes application of the
comments, Japanese PDF generation with Cozy and update of the existing @Active
file. Capture-time states below retain what had been done when each comment
was recorded; the adoption record below owns current revision status.
Historical journals remain unchanged. HTML and Git commits are not selected.

## Adoption record — 2026-11-13

| Comments | Applied source evidence |
| --- | --- |
| R01 | Japanese self-reference is consistently 「本技術ガイド」. |
| R02/R04/R06 | Purpose and scope lead the guide; descriptive DDD highlights explain system correspondences without a deficiency/superiority narrative or general modeling lesson. |
| R03 | Selected three-book coverage and adopted-meaning tables, chapter locators and verified scope/emphasis distinctions precede the platform mapping. Full-text definitions and unproved omissions remain explicitly unverified. |
| R05 | The opening figure classifies DDD concepts, shared/supporting patterns and platform mechanisms with a legend and connections. |
| R07/R08/R09/R11 | CQRS appears in the first figure; update/read labels and consistent green/blue arrows continue through all five diagram subjects. |
| R10/R13 | Strategic/tactical highlights are separate; Bounded Contexts map to subsystem/component modeling boundaries and their public relationships. |
| R12 | Value Objects connect to both update and read routes; conceptual sharing is distinguished from identical runtime instances or model shapes. |
| R14 | Ubiquitous Language connects BoK terms to Entity/value modeling and to knowledge, with context and provenance maintained. |

Core, Japanese/English Documents and SmartDox now have 11 chapters, 23
subsections, 84 blocks per locale, 12 tables and five figures per locale.
Existing 32 Step identities and 74 block identities are retained. Static
correspondence checks pass. Rendering and Drive delivery are recorded after
their actual verification, separately from source adoption.

## DDD-R01 — Self-reference terminology

- Requested wording: use 「本技術ガイド」 instead of 「本書」 when referring to
  this technical guide itself.
- Scope for a later revision: Japanese Document prose and derived SmartDox,
  including 「本書では」 and 「本書の」 occurrences.
- Preserve titles and quotations referring to other books; this comment concerns
  the guide's self-reference.
- State: recorded; not applied to source.

## DDD-R02 — Purpose and reader perspective

- The user clarified that this guide serves readers who want to understand
  SimpleModeling and Textus/CNCF through a DDD perspective.
- Explain how DDD concepts and design concerns correspond to the platform's
  modeling concepts, component boundaries and execution mechanisms. Clarify
  differences and related concepts where the correspondence is not direct;
  do not classify every platform mechanism as a DDD concept.
- General SimpleModeling/CNCF modeling practices will have their own guide,
  organized independently of a DDD-specific perspective. This guide does not
  own that general modeling procedure.
- This supersedes the assistant's earlier suggested purpose centered on a
  general requirements-to-model-to-implementation workflow. That suggestion
  was not applied to the manuscript.
- State: recorded; not applied to source.

Candidate Japanese purpose wording for the later revision:

> 本技術ガイドは、DDDの観点からSimpleModelingおよびTextus/CNCFのモデル構造と実行の仕組みを説明します。DDDの概念や設計上の関心事との対応を通じて、本システムの構成と設計方針を理解することを目的とします。一般的なモデリングの進め方は、別の技術ガイドで扱います。

## DDD-R03 — Compare the three books before mapping to SimpleModeling

- Compare Eric Evans's *Domain-Driven Design*, Vaughn Vernon's *Implementing
  Domain-Driven Design* and Vlad Khononov's *Learning Domain-Driven Design*
  before constructing the SimpleModeling correspondence.
- Do not presume a single uniform definition merely because books use the same
  term. Identify each book's definition, scope, assumptions, role and context.
- Record whether a concept is explicitly defined, discussed without a separate
  definition, expressed under another term, or not found in the inspected scope.
  Distinguish different emphasis from a genuinely different definition.
- Give edition and chapter/section evidence for each comparison. An unsuccessful
  index or text search alone does not prove that a concept is absent from a book;
  uninspected or inconclusive cases remain unverified.
- After the comparison, describe the SimpleModeling concept, its correspondence
  with each source meaning, non-equivalences and any platform-specific extension.
  Explain the CNCF execution connection on that basis. Preserve the distinction
  between DDD concepts and complementary implementation/architecture techniques.
- A working comparison should have columns for concept, each book's
  definition/coverage and source location, differences, SimpleModeling
  correspondence and CNCF connection. Keep unknowns visible rather than filling
  them with an assumed universal DDD definition.
- State: direction recorded. The cross-book comparison has not been performed;
  no individual definition difference or absence is asserted by this comment.

Refinement of purpose for the later revision: establish the source-specific
DDD vocabulary first, then use the resulting distinctions to explain
SimpleModeling and Textus/CNCF. General modeling practices remain separately
documented. Comment collection continues; manuscript and rendered outputs are
unchanged.

## DDD-R04 — Purpose, selected vocabulary and technique highlights

- The user observes that the existing PDF reads like a lecture on how to model.
  Reorganize the later revision around understanding SimpleModeling/Textus/CNCF
  from the DDD perspective established in DDD-R02.
- Open by defining this technical guide's purpose and intended reader.
- Next identify the DDD vocabulary selected from the three reference books.
  Use the source-specific distinctions from DDD-R03 to make the guide's adopted
  meanings explicit. Do not reproduce an undifferentiated glossary or all book
  contents.
- Organize the main content as highlights of the relevant DDD techniques:
  identify each technique, the concern or situation it addresses, how it is
  used in this system and its connection to SimpleModeling/platform mechanisms.
- Group techniques by concern or stage where useful. The user suggested stages
  as a possible organization, not a fixed sequence or a mandated development
  process. Do not turn the highlights into a step-by-step modeling tutorial.
- Distinguish the DDD technique itself from complementary techniques and the
  platform's implementation. Name the role each plays and avoid implying that
  all concepts in the system originate in DDD.
- State: direction recorded; source revision and cross-book analysis have not
  been selected or performed by this comment-collection task.

Working outline for the later revision:

1. Purpose, reader and scope of this technical guide.
2. Reference books, selected DDD terms and the meanings adopted here.
3. DDD technique highlights, grouped by relevant concern or stage.
4. Correspondence and complementary mechanisms in SimpleModeling/Textus/CNCF,
   presented alongside each highlight where possible; summarize shared
   connections only when that avoids duplication.
5. References and source-specific differences needed to interpret the highlights.

Each highlight should answer: which DDD technique, which concern or situation,
how this system uses it, which model/platform element corresponds to it, and
which source meaning is being used. This outline is a reader-facing explanation
plan; it does not prescribe a general SimpleModeling development procedure.

## DDD-R05 — Opening diagram: distinguish DDD and complementary techniques

- The user considers the opening diagram broadly useful. Retain its overall
  role as an overview rather than replacing it without cause.
- Clarify which elements represent DDD concepts/techniques, which represent
  complementary modeling/architecture techniques, and which represent
  SimpleModeling/Textus/CNCF-specific models or runtime mechanisms.
- Explain the relationships between these groups, not only their membership.
  A connection should identify the actual correspondence, supporting role or
  execution connection rather than implying that every connected element is
  itself part of DDD.
- Ground classifications in the three-book comparison. Being discussed in a
  DDD book does not alone establish that a technique originated in DDD or is
  uniquely a DDD technique; record shared concepts and ambiguous cases explicitly.
- A later diagram revision may use grouping, labels and a legend to make the
  distinction visible, supported by a short explanation of the connections.
  Specific classifications, visual treatment and connection labels remain to
  be established; this note does not claim a completed classification.
- State: comment recorded; opening diagram, manuscript and PDF are unchanged.

## DDD-R06 — DDD as an entry point to the wider system; neutral framing

- Use DDD as the reader's entry point for understanding the wider SimpleModeling
  system and its Textus/CNCF connections. Present useful conceptual hooks and
  correspondences through which readers can explore that overall structure.
- Explain each technique's responsibility and its relationships to other
  modeling, implementation and runtime elements as factual connections.
- The user explicitly rejects a negative framing such as "DDD alone is not
  enough", "DDD is inadequate" or a narrative that the platform repairs DDD's
  deficiencies. Do not turn distinctions between responsibilities into criticism
  of DDD or a comparison asserting platform superiority.
- Neutral descriptions can identify, for example, the domain meaning/boundary
  addressed by a DDD concept and the persistence, execution or presentation
  mechanisms connected to that concern. Specific correspondences still require
  the source-based comparison and should not be invented during comment capture.
- The overview and technique highlights should offer routes into understanding
  the whole system, rather than recasting the document as a general modeling
  tutorial or an exhaustive DDD textbook.
- Apply neutral factual prose consistently to the purpose, diagram legend,
  transitions and technique highlights. Describe roles and relationships directly
  without a deficiency/remedy or superiority narrative.
- State: direction recorded; no manuscript, diagram or rendered-output changes.

## DDD-R07 — Include CQRS

- The user explicitly requested CQRS (Command Query Responsibility Segregation)
  as a topic in this guide.
- Use separation of update and read models as a conceptual connection to the
  system's Command, Query and View responsibilities. Explain its relationship
  to the DDD models, alongside the other technique highlights.
- Retain source-specific distinctions and the neutral relationship framing.
  Do not assume CQRS is uniquely a DDD concept, that it is mandatory for every
  domain, or that model separation necessarily prescribes separate databases
  or Event Sourcing. Establish the adopted meanings and actual correspondence
  during the later source-based revision.
- The current manuscript already has a CQRS subsection; retain the subject
  and give it an explicit place in the revised overview/highlights. The user
  request is a topic requirement, not an implementation mandate or a claim
  that the present explanation has been accepted.
- State: topic recorded; existing CQRS prose, diagram and PDF are unchanged.

## DDD-R08 — Keep read and update paths visibly distinct throughout diagrams

- The user emphasized that the distinction between read-side and update-side
  responsibilities is central to the CQRS explanation and must remain visible
  consistently through the relevant diagrams, not only in a dedicated CQRS figure.
- Show which elements and connections belong to each side and where results or
  committed facts connect them. Choose labels, grouping or a legend consistently
  in the later diagram revision; do not invent a relationship to fill the picture.
- The user then began describing "read-side techniques and ..." and paused to
  ask for the current discussion position. The continuation is recorded in
  DDD-R09 below.
- State: emphasis recorded; diagram and manuscript changes remain deferred.

## DDD-R09 — Locate DDD techniques within the two related paths

- Organize the explanation around two related paths: updates and reads. Make
  the responsibilities of each path and their connections understandable.
- Within those paths, identify where each selected DDD technique is used, what
  concern it addresses and how it relates to the connected SimpleModeling
  models and implementation/runtime mechanisms.
- The relationship between the two paths and the placement/role of DDD
  techniques are parts of one explanation, not independent technique lists.
- Do not assume in advance that every DDD concept belongs only to the update
  side or that the read side has no connection to domain meaning. Identify
  shared concerns and actual connections from the source-based correspondence.
- This is the DDD-oriented reader explanation requested in DDD-R02/04, not a
  general modeling procedure or a requirement for physically separate stores.
- State: continuation recorded; classifications and concrete diagrams remain
  for the later revision. No manuscript or rendered output is changed.

## DDD-R10 — Separate strategic and tactical design

- Present strategic design and tactical design as two distinct areas of DDD
  techniques. Make that distinction explicit in the overview and highlights.
- The user identifies strategic design, especially context-related concerns,
  as a useful connection to component decomposition. Explain that relationship
  in the later source-based mapping without assuming a universal one-to-one
  equivalence between a Bounded Context and a deployment/component unit.
- Relate this distinction to the existing read/update paths. These are different
  explanatory axes, not interchangeable pairs; do not equate strategic design
  with one path and tactical design with the other.
- The user began describing the other area but paused to request a summary.
  The tactical area's detailed emphasis is not yet specified; do not invent
  that continuation or attribute examples to the user.
- State: direction recorded. No source revision, diagram change, book comparison
  or rendered-output update has been performed during comment collection.

## DDD-R11 — Include CQRS in the opening overview diagram

- The user explicitly requests CQRS in the first overview diagram itself.
  A later dedicated CQRS figure or a prose-only explanation is not sufficient
  to satisfy this placement requirement.
- In that overview, distinguish update and read responsibilities and show
  their actual connections, alongside the DDD/complementary/platform distinctions
  recorded in DDD-R05. Carry the same distinction through subsequent relevant
  diagrams as recorded in DDD-R08/09.
- CQRS belongs in the revised opening picture as part of its explanation of
  the whole system; physical storage separation or Event Sourcing is not
  implied by the request.
- State: explicit diagram requirement recorded for the later revision;
  diagram sources, images, manuscript and PDF remain unchanged.

## DDD-R12 — Value Objects in both read and update paths

- The user expects Value Objects to appear in both the read and update routes
  of the opening overview. Show their use and relationships on both sides.
- Do not assign each DDD technique exclusively to one CQRS side merely to make
  a two-column picture. Identify techniques and domain meanings shared across
  the routes, while keeping each route's responsibility clear.
- The visual treatment may use a shared concept with connections to both
  routes or clearly labeled occurrences on each side. The requirement concerns
  conceptual use, not sharing the same runtime object instance or requiring
  identical read/write model shapes.
- State: diagram guidance recorded; no diagram or manuscript revision yet.

## DDD-R13 — Bounded Contexts and subsystem/component boundaries

- For strategic design, explain defining Bounded Contexts and the relationships
  between those contexts.
- The user specifies the SimpleModeling modeling policy: concretize a Bounded
  Context boundary as a subsystem or component boundary, and develop the model
  on that basis. Present this as the system's adopted correspondence, not merely
  an unspecified possible association.
- Explain context relationships alongside the corresponding relationships
  between the modeled subsystems/components. Concrete relationship forms and
  terminology remain subjects of the source-based comparison and further comments.
- This clarification makes the local policy more specific than DDD-R10's
  earlier caution about assuming equivalence. Preserve the distinction between
  SimpleModeling's adopted modeling policy and a universal requirement imposed
  by DDD on every system.
- Do not infer a mandatory one-context/one-process/one-deployment/one-host
  topology or a fixed subsystem-to-component cardinality from this comment.
- State: adopted modeling correspondence recorded; Core, manuscript and diagram
  sources remain unchanged during comment collection.

## DDD-R14 — Ubiquitous Language, BoK terms, Entities and knowledge

- The user identifies a close correspondence between DDD Ubiquitous Language
  and the terminology managed in the BoK. Explain that correspondence as a
  conceptual entry point into SimpleModeling's terminology/model/knowledge links.
- Distinguish and relate two paths: terminology developed into Entity models,
  and terminology connected to knowledge. Show how both retain the intended
  business meaning and relate to the language used in domain modeling.
- Relate the terminology to its applicable context, consistently with the
  Bounded Context/subsystem/component policy in DDD-R13. Do not presume a term
  has one universal meaning across all contexts.
- Explain the actual role of term management, model development and knowledge
  connections rather than equating Ubiquitous Language with a glossary alone.
  No automatic conversion of every BoK term into an Entity, or already delivered
  terminology-to-model/knowledge automation, is asserted by this comment.
- State: correspondence and explanation requirement recorded; detailed source
  mapping and manuscript/diagram revision remain for the later authoring task.

## Verified delivery — 2026-11-13

The Japanese PDF is A4, 17 pages and 887240 bytes. All pages passed
visual inspection; all 358 source text values are present after
layout/link/hyphen normalization. Five diagram subjects are maintained in both
locales. The existing @Active file was updated in place and connector readback
confirmed PDF MIME type, size and parent. Sources and old outputs are preserved;
book-comparison limits remain visible. No HTML or Git commit was selected.

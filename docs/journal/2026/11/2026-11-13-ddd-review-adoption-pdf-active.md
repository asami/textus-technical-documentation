# DDD Review Adoption and PDF Update in @Active

Date: 2026-11-13
Status: comments applied; Japanese Cozy PDF checked and updated in place.

## Request and adopted source

The user closed the comment round and requested a PDF and Google Drive delivery.
[DDD-R01 through DDD-R14](../../../notes/ddd-modeling-guide-review.md) now have
source adoption records. The guide starts from purpose and source-specific DDD
vocabulary, then explains the system through strategic/tactical highlights and
CQRS update/read connections. Its opening figure distinguishes DDD concepts,
shared/supporting techniques and platform mechanisms; Value Objects connect to
both routes. Contexts map to subsystem/component modeling boundaries, and shared
language connects BoK terms to Entity/value models and knowledge.

Core, both Documents and SmartDox contain 11 chapters, 23 subsections, 84 blocks
per locale, 12 tables and five figures per locale. Existing 32 Step and 74 block
identities are retained. Sources and diagram masters/images were preserved before
editing. Historical journals and unrelated work remain unchanged.

## Source comparison and limits

The selected English editions are Evans 2003, Vernon 2013 and Khononov 2021.
Published contents and identified public chapter previews establish locations
and explanatory scope/emphasis. The guide distinguishes those observations from
its adopted meanings and platform mappings. Full-text definition equivalence and
absence of concepts from an entire book are not claimed. The references record
chapter locators and URLs. Official Evans reference endpoints returned HTTP 403;
that later reference was not substituted for the 2003 book.

## Native generation and retained corrections

PlantUML generated ten localized images. An initial sandbox Java process aborted;
scoped host execution then reported a sequence-label syntax error. Parent corrected
literal participant-label line breaks, group label text and note/legend formatting,
and qualified the resulting images. No denied action was replayed.

The first native Cozy PDF call exited 1 with
`AnnotationState#get_Block_Macro_Transition`. Parent traced this to a figure
annotation it had introduced before localized image spans, then restored the
existing supported span/blank-line/plain-caption representation. That failed
result remains at `/tmp/skill.cncf.d/a-951bf7e3-96fe-4df1-ae53-7e6a21fd98c7/result.json`.
The corrected request exited 0. PDF QA then identified two stale bibliographic
section names; those names were aligned with revised headings, and a fresh final
request rendered the current source.

Registered `cozy_command_runner` `/root/ddd_final_pdf_20261113`, GPT-6 Luna / low,
used the exact adapter and first-attempt scoped escalation. It completed with
exit 0; parent `verify_completed` admitted the terminal result. The native route
was standalone Cozy `pdf --locale ja --renderer latex --latex-format business`,
local runtime `0.3.3-SNAPSHOT`. Earlier inspection routing records were unchanged;
per-command authority and result evidence were retained. No SBT was run.

## Qualification and delivery

The [Japanese PDF](../../../../src/main/smartdox/technical-guide/ddd/textus-cncf-ddd-architecture.dox/target/textus-cncf-ddd-architecture-ja.pdf)
is A4, 17 pages, 887240 bytes. All pages were visually checked for
clipping, glyphs, labels, table continuation, margins and page numbers. All
358 source headings/prose/captions/header/cell values are present
after layout/link/hyphen normalization; no blank page or replacement glyph remains.

The [existing @Active file](https://drive.google.com/file/d/1_zQT7aZrtvkSmF8GmOH9us5Rthc8bPJe/view?usp=drivesdk) was updated in place. Connector readback
confirmed unchanged file ID `1_zQT7aZrtvkSmF8GmOH9us5Rthc8bPJe`, PDF MIME type, 887240 bytes
and parent `0B_D_9VB5REQCMzIwNmYyMmYtNzQzNS00Y2RmLWE1ZDAtNTdlYjQ4YTYwOTM0`.
Sharing was preserved. The parent owns this authorized connector mutation; the
runners performed local generation only.

Snapshots, private authoring/validation records, native request locators,
page images, extracted text and connector responses are retained under
`/private/tmp/skill.cncf.d/a-14d4dbc7-a955-496f-bb9e-b84643bd87d1/`. No HTML, additional language PDF, other-guide change, runtime test,
Git commit or push was selected.

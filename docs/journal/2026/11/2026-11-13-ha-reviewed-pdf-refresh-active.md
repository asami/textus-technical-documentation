# Reviewed HA PDF Refresh in @Active

Date: 2026-11-13
Status: generated with Cozy, checked and updated in place

## Request and source scope

The user explicitly requested regeneration of the HA PDF from the reviewed
content and placement in @Active, and specified Cozy as the PDF producer. This
supersedes the earlier comment-round deferral; earlier journals remain immutable.

The guide has eight chapters, 22 subsections, 99 localized blocks, 13 tables and
two figures per locale. It now explains HA purpose/level and overall structure,
role/control/data/deployment areas, separate Switchover and Failover, Read-only
for failure and maintenance, resident-read continuity, activity-scoped Working
Sets and business-cache retention. The appendix adds registered Phase 123/124
plans through shared Core, Japanese/English Documents and SmartDox. Both plans
remain unstarted; Phase 108 acceptance is unchanged.

## Generation and qualification

The existing standalone Cozy `pdf` route used runtime `0.3.3-SNAPSHOT` from the
local Cozy checkout, `--locale ja --renderer latex --latex-format business`.
Registered `cozy_command_runner` `/root/ha_pdf_refresh_20261113`, GPT-6 Luna / low,
received first-attempt scoped escalation, exited 0 and completed terminally.
Parent `verify_completed` accepted the result. The earlier inspection routing
record and earlier PDF evidence were retained, and no SBT was run.

The [Japanese PDF](../../../../src/main/smartdox/technical-guide/availability/textus-cncf-availability-architecture.dox/target/textus-cncf-availability-architecture-ja.pdf)
is A4, 15 pages and 441635 bytes. All 15 page PNGs were visually inspected for
glyphs, diagram labels, tables/continuations, page numbering, margins and clipping.
All 308 source headings/prose/captions/header/cell values are present in extracted
text after normalizing rendered link labels, page footers, whitespace and Latin
discretionary hyphenation. No blank page or replacement glyph was found.

## Drive delivery and evidence

The existing [@Active HA PDF](https://drive.google.com/file/d/1mP-b8DXSqPZHe0gMOAoJ3VtnZqIYM-2i/view?usp=drivesdk)
was updated in place. Connector readback confirmed PDF MIME type, 441635 bytes,
the unchanged file ID and parent folder
`0B_D_9VB5REQCMzIwNmYyMmYtNzQzNS00Y2RmLWE1ZDAtNTdlYjQ4YTYwOTM0`.
No new sharing permission was added. The runner performed local generation only;
the parent performed the authorized connector update.

Execution/result, parent verification, page images, text checks and connector
responses are retained in
`/private/tmp/skill.cncf.d/a-5e758098-b1b2-4ffc-8e8e-63c5b0cdd718/`.
Source and earlier-PDF preservation is under
`/private/tmp/skill.cncf.d/a-7f62d51a-6f6c-4973-8cda-a5594e5d4708/before-pdf-refresh/`.

No other guide PDF, HTML, public-site publication, implementation test, runtime
change, Git commit or push was selected.

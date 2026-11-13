# HA and Immutable Infrastructure PDFs in @Active

Date: 2026-11-13
Status: Japanese PDFs generated, visually checked and uploaded

## Request and selected route

The user requested PDFs for the HA and immutable-infrastructure guides and
placement in the existing Google Drive @Active folder. Japanese was selected
consistently with prior guide distribution. The existing standalone `cozy pdf`
route, `--locale ja --renderer latex --latex-format business`, consumed each
current bilingual `index.dox` directly. The Document Project HTML routes and
the media/infographic product graph were not selected or represented as PDF
producers. Runtime selection was `0.3.3-SNAPSHOT` from the local Cozy checkout.

Two registered `cozy_command_runner` first-command delegations used
GPT-6 Luna / low, separate project output directories and fresh exact builders.
Both received scoped escalated execution on the first attempt and exited 0.
Parent `verify_completed` accepted the terminal results. No SBT was run.

The previous read-only inspection routing record and failed inspection evidence
remain unchanged. This newly authorized PDF-production boundary used explicit
per-command artifact-write authority and original result evidence, without
reusing the old child, expanding its saved scope, fabricating a task identity,
or retrying the earlier descriptor inspection. Parent-owned Drive upload was
separate from the runners, whose remote writes remained forbidden.

## Delivered files

- [HA PDF](../../../../src/main/smartdox/technical-guide/availability/textus-cncf-availability-architecture.dox/target/textus-cncf-availability-architecture-ja.pdf): A4, six pages, 178332 bytes. [Drive copy](https://drive.google.com/file/d/1mP-b8DXSqPZHe0gMOAoJ3VtnZqIYM-2i/view?usp=drivesdk).
- [Immutable Infrastructure PDF](../../../../src/main/smartdox/technical-guide/immutable-infrastructure/textus-cncf-immutable-infrastructure.dox/target/textus-cncf-immutable-infrastructure-ja.pdf): A4, six pages, 177301 bytes. [Drive copy](https://drive.google.com/file/d/1Mth0Btpo5a4gWe_x35hWxkyHjhRgYHgu/view?usp=drivesdk).

The verified destination is folder
`0B_D_9VB5REQCMzIwNmYyMmYtNzQzNS00Y2RmLWE1ZDAtNTdlYjQ4YTYwOTM0`.
Search found no same-name PDFs there before upload. Upload responses and
metadata readback confirmed both PDF MIME types, exact byte sizes, destination
parents and returned viewing URLs. Existing sharing was preserved.

## Validation and evidence

All twelve page PNGs were visually inspected for text clipping, missing glyphs,
overlap, table rows and page numbering. Normalized extracted text contains all
129 HA and 106 immutable-infrastructure source paragraph/caption/header/cell
values. The immutable operation table continues intact across a page boundary.

Private delegation, terminal verification, page images, extracted text, QA and
Drive responses are retained under
`/private/tmp/skill.cncf.d/a-de738287-61be-476d-917c-bed4233ef7e1/`.
Native execution results remain at
`/tmp/skill.cncf.d/a-6be89dc0-5397-4f5e-bd67-dbbf0538f4f7/result.json`
and `/tmp/skill.cncf.d/a-dbb34b05-5dad-464e-8ee9-1dbbc553309e/result.json`.

The manuscripts did not change during rendering. Repository navigation and
current project READMEs now record the deliveries. Historical journals were
not edited. No HTML, additional language PDF, Security PDF, runtime test,
publication to a public site, commit or push was selected.

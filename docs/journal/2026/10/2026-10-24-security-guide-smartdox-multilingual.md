# Security Guide: SmartDox and Multilingual Source

Date: 2026-10-24

## Request

Convert the initial Markdown security guide under `src/main/smartdox/security` to SmartDox and make it multilingual.

## Changes

- Added `src/main/smartdox/security/textus-cncf-security-architecture.dox` as the canonical product source, with draft metadata and the existing logical document identity.
- Preserved all 18 sections, 57 original Japanese body paragraphs, ten list items, and twelve security-control rows.
- Added full English body text and Japanese section titles and table cells. The guide has 94 paired language units, including its summary and table headings.
- Used SmartDox bilingual titles and adjacent language spans so both editions share the same document structure.
- Preserved Component, Capability, Guard, ExecutionContext, AuthHandle, and other technical identifiers. Translation does not promote design descriptions into claims of implementation completion or security assurance.
- Moved the original Markdown unchanged to `docs/notes/security/textus-cncf-security-architecture-initial.md`, retaining it as historical input rather than a competing product source.
- Documented the source convention and build boundary in README.

## Verification

Source-level checks confirm that every original content block is accounted for, all original Japanese body paragraphs and list items are preserved, every language pair is nonempty and well-formed XML, and all table cells have both language variants. The document has 18 sections and twelve matrix data rows.

Native HTML/PDF generation and Documentation CAR packaging were not run or integrated in this source migration. Phase 1 remains planned. No runtime security testing, publication, or release is claimed.

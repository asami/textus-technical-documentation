# Textus Technical Documentation Component

Status: initial design
Date: 2026-10-24

## Purpose

Provide Textus/CNCF technical explanations as a first-class Document Component.
Internal project material belongs under `docs/`. Product documentation belongs under `src/main/` and is built as versioned Component content.

## Publication model

SmartDox is the semantic source of truth. A logical Document may have multiple language editions and rendered formats. The normal release profile includes Web/HTML, Markdown/text, MCP-readable content/metadata, and PDF suitable for direct human distribution.

PDF is normally included in the Documentation CAR. A lightweight profile may omit it, but the canonical release should have one deterministic artifact set.

## Initial content

The first major document is the Textus/CNCF Security Architecture Technical Guide. It also serves as the reference case for multilingual/multi-format Document Component generation and distribution.

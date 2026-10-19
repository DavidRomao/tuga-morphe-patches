# Contributing to Tuga Morphe Patches

Thank you for considering contributing!

## Reporting bugs

- Search existing [bug reports](https://github.com/DavidRomao/tuga-morphe-patches/issues?q=label%3A%22Bug+report%22) before opening a new one.
- Include the exact app version/variant you tested, the Morphe Manager/Desktop version used, and full logs if available.

## Proposing changes

- Open an issue describing the change before submitting a large pull request.
- Follow the conventions described in the [Morphe Patcher documentation](https://github.com/MorpheApp/morphe-patcher/blob/main/docs/3_structure_and_conventions.md):
  keep patches minimal, document non-obvious bytecode changes, and prefer resilient fingerprints
  (avoid matching on obfuscated names or local register numbers that can change between app updates).
- Use [semantic commit messages](https://kapeli.com/cheat_sheets/Semantic_Commits.docset/Contents/Resources/Documents/index)
  (`feat:`, `fix:`, `chore:`) as described in the [README](README.md).

## Code of conduct

Be respectful and constructive. This is a community project maintained on a best-effort basis.

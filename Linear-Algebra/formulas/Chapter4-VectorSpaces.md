# Chapter 4 — Vectors, spaces, span, and independence

Sections 4.1–4.4: vectors, vector spaces, subspaces, spanning sets, and linear dependence/independence. Sections 10–11 record the next connections from 4.5–4.6 (basis, dimension, and rank). Assume scalars are real numbers unless a problem says otherwise.

## 1. Vectors and notation

A vector is an element of a vector space. Depending on the space, a vector may be a coordinate list, matrix, polynomial, or function.

A scalar is a number used to multiply a vector.

**ℝⁿ = {(x₁, x₂, …, xₙ) : xᵢ ∈ ℝ}**

| Notation | Meaning |
| --- | --- |
| 𝐯 ∈ V | 𝐯 belongs to V |
| W ⊆ V | Every element of W belongs to V |
| 𝟎 | The zero vector of the space |
| { ⋯ } | A set |
| span(S) | All linear combinations of vectors in S |
| Pₙ | Real polynomials of degree at most n, including the zero polynomial |
| Mₘ,ₙ | All real m×n matrices |

For vectors in ℝⁿ:

**𝐮 + 𝐯 = (u₁ + v₁, …, uₙ + vₙ)**

**c𝐮 = (cu₁, …, cuₙ)**

**−𝐮 = (−u₁, …, −uₙ),    𝐮 − 𝐯 = 𝐮 + (−𝐯)**

Two vectors are equal exactly when their corresponding components are equal.

## 2. Definition of a vector space: all ten axioms

A vector space is a nonempty set V, together with vector addition and scalar multiplication, satisfying the following properties.

These must hold for every 𝐮, 𝐯, 𝐰 ∈ V and all scalars c, d.

| # | Property | Equation or requirement |
| --- | --- | --- |
| 1 | Closure under addition | 𝐮 + 𝐯 ∈ V |
| 2 | Commutativity of addition | 𝐮 + 𝐯 = 𝐯 + 𝐮 |
| 3 | Associativity of addition | (𝐮 + 𝐯) + 𝐰 = 𝐮 + (𝐯 + 𝐰) |
| 4 | Additive identity | There is a 𝟎 ∈ V such that 𝐮 + 𝟎 = 𝐮 |
| 5 | Additive inverses | For every 𝐮, there is a −𝐮 ∈ V such that 𝐮 + (−𝐮) = 𝟎 |
| 6 | Closure under scalar multiplication | c𝐮 ∈ V |
| 7 | Distributivity over vector addition | c(𝐮 + 𝐯) = c𝐮 + c𝐯 |
| 8 | Distributivity over scalar addition | (c + d)𝐮 = c𝐮 + d𝐮 |
| 9 | Compatibility of scalar multiplication | c(d𝐮) = (cd)𝐮 |
| 10 | Scalar identity | 1𝐮 = 𝐮 |

Closure means the result stays in the set.

A vector space includes both the set and its operations. If a question defines unusual addition or scalar multiplication, use those definitions when checking the axioms.

### Consequences of the axioms

These are derived properties:

**0𝐯 = 𝟎**

**c𝟎 = 𝟎**

**(−1)𝐯 = −𝐯**

**(−c)𝐯 = −(c𝐯) = c(−𝐯)**

**c𝐯 = 𝟎  ⟹  c = 0 or 𝐯 = 𝟎**

The zero vector is unique, and each vector has a unique additive inverse.

Cancellation also holds:

**𝐮 + 𝐰 = 𝐯 + 𝐰  ⟹  𝐮 = 𝐯**

### Common vector spaces with standard operations

| Space | Its vectors | Zero vector |
| --- | --- | --- |
| ℝⁿ | Lists of n real numbers | (0, …, 0) |
| Mₘ,ₙ | m×n matrices | The all-zero matrix |
| Pₙ | Polynomials of degree at most n | The zero polynomial |
| C[a, b] | Continuous real functions on [a, b] | f(x) = 0 |
| {𝟎} | Only the zero vector | 𝟎 |

Polynomials of exactly degree n do not form a vector space under standard operations: they exclude the zero polynomial.

## 3. Subsets and subspaces

A subset is simply a collection whose elements belong to a larger set.

A subspace W of a vector space V is a subset that is itself a vector space using the same operations as V.

### The subspace test

To prove W is a subspace, verify:

**𝟎 ∈ W**

**𝐮, 𝐯 ∈ W  ⟹  𝐮 + 𝐯 ∈ W**

**𝐮 ∈ W, c ∈ ℝ  ⟹  c𝐮 ∈ W**

An equivalent version combines the two closure conditions:

**W ≠ ∅ and a𝐮 + b𝐯 ∈ W**

for every 𝐮, 𝐯 ∈ W and all scalars a, b.

Why only these checks? The other algebra rules are inherited from the larger vector space.

### Proof versus disproof

- To prove closure, use arbitrary vectors and arbitrary scalars.
- To disprove a requirement, one counterexample is enough.
- If the zero vector is missing, stop: it is not a subspace.
- Containing zero alone does not prove it is a subspace.

### Examples and patterns

| Set under standard operations | Subspace? | Reason |
| --- | --- | --- |
| {(x, y) : y = 3x} | Yes | Zero and both closure conditions hold |
| {(x, y) : y = 3x + 1} | No | Excludes zero |
| {(x, y) : x ≥ 0, y ≥ 0} | No | Negative scaling can leave the set |
| {(x, y) : xy = 0} | No | (1, 0) + (0, 1) = (1, 1) leaves the set |
| {𝟎} | Yes | Passes all three checks |
| V itself | Yes | Every vector space is a subspace of itself |

The subspaces of ℝ² are exactly:

- {𝟎}
- Lines through the origin
- All of ℝ²

The subspaces of ℝ³ are exactly:

- {𝟎}
- Lines through the origin
- Planes through the origin
- All of ℝ³

### Homogeneous systems produce subspaces

For an m×n matrix A,

**W = {𝐱 ∈ ℝⁿ : A𝐱 = 𝟎}**

is a subspace of ℝⁿ.

This set is called the null space of A:

**Null(A) = {𝐱 : A𝐱 = 𝟎}**

The closure calculations are:

**A(𝐮 + 𝐯) = A𝐮 + A𝐯 = 𝟎**

**A(c𝐮) = c(A𝐮) = 𝟎**

If 𝐛 ≠ 𝟎, the solution set of A𝐱 = 𝐛 is not a subspace because it does not contain 𝐱 = 𝟎.

### Other useful subspace facts

- The intersection of two subspaces is a subspace.
- The union of two subspaces is generally not a subspace.
- A union of two subspaces is a subspace precisely when one is contained in the other.

## 4. Linear combinations

A linear combination of vectors 𝐯₁, …, 𝐯ₖ is an expression

**c₁𝐯₁ + ⋯ + cₖ𝐯ₖ**

where c₁, …, cₖ are scalars, called coefficients.

A vector 𝐛 is a linear combination of those vectors if there exist coefficients satisfying

**c₁𝐯₁ + ⋯ + cₖ𝐯ₖ = 𝐛**

For example,

**3(1, 0) − 2(0, 1) = (3, −2)**

### Matrix connection

Put the vectors into the columns of a matrix:

```
        ⎡ |   |        | ⎤
A   =   ⎢ 𝐯₁  𝐯₂  ⋯  𝐯ₖ ⎥
        ⎣ |   |        | ⎦
```

Then

**A𝐜 = c₁𝐯₁ + ⋯ + cₖ𝐯ₖ**

Thus,

**𝐛 is a linear combination  ⟺  A𝐜 = 𝐛 is consistent**

Row-reduce [A | 𝐛] to test this.

A row of the form

**[ 0  0  ⋯  0  |  d ]  with d ≠ 0**

means the system is inconsistent, so 𝐛 cannot be made from the given vectors.

## 5. Span and spanning sets

The span of S = {𝐯₁, …, 𝐯ₖ} is the collection of every linear combination:

**span(S) = {c₁𝐯₁ + ⋯ + cₖ𝐯ₖ : cᵢ ∈ ℝ}**

A set S ⊆ V spans V when

**span(S) = V**

That means every vector in V can be written as a linear combination of vectors in S.

### Facts about span

- The span of any collection of vectors in V is a subspace of V.
- It contains all the original vectors.
- It contains 𝟎.
- It is the smallest subspace containing the original vectors.
- Adding a vector already in the span does not enlarge the span.

For example,

**span{(1, 2), (2, 4)} = span{(1, 2)}**

### Geometric meaning

| Vectors | Their span |
| --- | --- |
| Only zero vectors | {𝟎} |
| One nonzero vector | A line through the origin |
| Two independent vectors in ℝ³ | A plane through the origin |
| Three independent vectors in ℝ³ | All of ℝ³ |

### Testing whether vectors span ℝᵐ

If A has those vectors as its columns,

**Columns span ℝᵐ  ⟺  A has a pivot in every row**

Equivalently,

**A𝐜 = 𝐛**

must be consistent for every 𝐛 ∈ ℝᵐ.

Be careful: showing that one particular vector is in the span does not prove that the vectors span the entire target space.

## 6. Linear independence and dependence

Vectors 𝐯₁, …, 𝐯ₖ are linearly independent if

**c₁𝐯₁ + ⋯ + cₖ𝐯ₖ = 𝟎**

has only the solution

**c₁ = c₂ = ⋯ = cₖ = 0**

This is the trivial solution.

They are linearly dependent if the same equation has a solution where

**at least one coefficient is nonzero**

This is a nontrivial solution.

### Equivalent meaning of dependence

A set is dependent exactly when at least one vector can be written as a linear combination of the others.

For example,

**𝐯₃ = 2𝐯₁ − 𝐯₂**

gives the dependence relation

**2𝐯₁ − 𝐯₂ − 𝐯₃ = 𝟎**

The coefficients 2, −1, −1 demonstrate dependence.

### Matrix test

Put the vectors into columns of A, then solve

**A𝐜 = 𝟎**

| Outcome | Conclusion |
| --- | --- |
| Every variable is a pivot variable | Independent |
| At least one free variable | Dependent |
| Only the trivial solution | Independent |
| A nontrivial solution exists | Dependent |

Therefore,

**Independent columns  ⟺  a pivot in every column**

**Dependent columns  ⟺  at least one column has no pivot**

A homogeneous system is always consistent because setting all variables equal to zero always works.

### Useful shortcuts

| Situation | Conclusion |
| --- | --- |
| The set contains 𝟎 | Dependent |
| Two vectors are identical | Dependent |
| One vector is a scalar multiple of another | Dependent |
| One vector is a combination of the others | Dependent |
| A set contains a dependent subset | Dependent |
| One nonzero vector by itself | Independent |
| Any subset of an independent set | Independent |
| More than m vectors in ℝᵐ | Dependent |

For two vectors, dependence means one is a scalar multiple of the other.

For three or more vectors, checking pairs for scalar multiples is insufficient.

Example:

**(1, 0), (0, 1), (1, 1)**

are dependent because

**(1, 0) + (0, 1) − (1, 1) = (0, 0)**

## 7. How spanning and independence fit together

For an m×k matrix A, there are k column vectors, each in ℝᵐ.

| Question | Required condition |
| --- | --- |
| Do the columns span ℝᵐ? | Pivot in every row |
| Are the columns independent? | Pivot in every column |

Spanning asks whether you can make everything in the target space. Independence asks whether any of your starting vectors is redundant.

A set can satisfy either condition, both, or neither.

| Set | Spans ℝ²? | Independent? |
| --- | --- | --- |
| {(1, 0), (0, 1)} | Yes | Yes |
| {(1, 0), (0, 1), (1, 1)} | Yes | No |
| {(1, 0)} | No | Yes |
| {(1, 0), (2, 0)} | No | No |

### Counting shortcuts in ℝᵐ

| Number k of vectors | What you know immediately |
| --- | --- |
| k < m | Cannot span ℝᵐ; independence is possible |
| k = m | Independent exactly when they span ℝᵐ |
| k > m | Must be dependent; spanning is possible |

Having exactly m vectors does not automatically mean they are independent or span ℝᵐ.

## 8. One worked example covering both tests

Let

```
        ⎡ 1 ⎤         ⎡ 0 ⎤         ⎡ 1 ⎤
𝐯₁  =   ⎢ 0 ⎥    𝐯₂ = ⎢ 1 ⎥    𝐯₃ = ⎢ 1 ⎥
        ⎣ 1 ⎦         ⎣ 1 ⎦         ⎣ 2 ⎦
```

Form

```
        ⎡ 1  0  1 ⎤
A   =   ⎢ 0  1  1 ⎥
        ⎣ 1  1  2 ⎦
```

Use R₃ ← R₃ − R₁ − R₂:

```
        ⎡ 1  0  1 ⎤
A   ~   ⎢ 0  1  1 ⎥
        ⎣ 0  0  0 ⎦
```

**Span:** There is no pivot in row three, so the vectors do not span ℝ³.

**Independence:** There is no pivot in column three, so the vectors are dependent.

To find the dependence relation, solve A𝐜 = 𝟎:

**c₁ + c₃ = 0,    c₂ + c₃ = 0**

Let c₃ = t. Then

**(c₁, c₂, c₃) = (−t, −t, t)**

Choose t = 1:

**−𝐯₁ − 𝐯₂ + 𝐯₃ = 𝟎**

Thus,

**𝐯₃ = 𝐯₁ + 𝐯₂**

Their span is the plane

**{(x, y, z) : z = x + y}**

## 9. Polynomials and matrices as vectors

For polynomials in P₂, match coefficients using a consistent order:

**a + bx + cx²  ↔  (a, b, c)**

For example,

**1 + 2x  ↔  (1, 2, 0),    x + x²  ↔  (0, 1, 1)**

Put these coefficient vectors into columns and apply the usual tests.

Polynomial equality means corresponding coefficients are equal:

**a + bx + cx² = d + ex + fx²  ⟺  a = d, b = e, c = f**

For matrices, use corresponding entries in a consistent order:

```
⎡ a  b ⎤         ⎡ a ⎤
⎣ c  d ⎦    ↔    ⎢ b ⎥
                 ⎢ c ⎥
                 ⎣ d ⎦
```

A linear combination of 2×2 matrices becomes a system with four scalar equations.

| Space | Number of independent coordinate positions |
| --- | --- |
| ℝⁿ | n |
| Pₙ | n + 1 |
| Mₘ,ₙ | mn |

Consequently, more than n + 1 polynomials in Pₙ, or more than mn matrices in Mₘ,ₙ, must be dependent.

## 10. Basis, dimension, and rank: the next connections

A basis for V is a set that:

1. Spans V.
2. Is linearly independent.

A basis gives enough vectors to make everything, with no redundant vectors.

The dimension of a finite-dimensional vector space is the number of vectors in any basis.

**dim(ℝⁿ) = n**

**dim(Pₙ) = n + 1**

**dim(Mₘ,ₙ) = mn**

Examples of standard bases:

**ℝ³: {(1, 0, 0), (0, 1, 0), (0, 0, 1)}**

**P₂: {1, x, x²}**

The rank of a matrix is its number of pivots:

**rank(A) = number of pivots**

Thus, for A of size m×k,

**Columns span ℝᵐ  ⟺  rank(A) = m**

**Columns are independent  ⟺  rank(A) = k**

To obtain a basis for the column span, identify pivot columns after row reduction, then select the corresponding columns from the original matrix.

## 11. Square-matrix shortcuts

If A is n×n, all of these statements are equivalent:

- A is invertible
- det(A) ≠ 0
- rref(A) = Iₙ
- A has n pivots
- Its columns are independent
- Its columns span ℝⁿ
- A𝐱 = 𝟎 has only the trivial solution
- A𝐱 = 𝐛 has exactly one solution for every 𝐛

For a 2×2 matrix,

```
        ⎡ a  b ⎤
A   =   ⎣ c  d ⎦
```

**det(A) = ad − bc**

If the determinant is nonzero, its two columns are independent and span ℝ².

Use the determinant shortcut only for square matrices.

## 12. Quiz decision table

| Problem asks you to… | Start with… | What establishes the answer? |
| --- | --- | --- |
| Prove a subset is a subspace | Zero, arbitrary 𝐮, 𝐯, arbitrary scalar c | Zero and both closure conditions |
| Show a set is not a subspace | Check zero, then closure | One failed condition |
| Express 𝐛 as a linear combination | [A \| 𝐛] | Solve for coefficients |
| Determine whether 𝐛 belongs to a span | [A \| 𝐛] | Consistency |
| Determine whether vectors span ℝᵐ | Row-reduce A | Pivot in every row |
| Determine independence | Solve A𝐜 = 𝟎 | Pivot in every column |
| Demonstrate dependence | Find a nontrivial solution of A𝐜 = 𝟎 | Give coefficients, not all zero |
| Remove redundant vectors while preserving the span | Find pivot columns | Keep corresponding original columns |

The four equations to remember first:

**Linear combination:    c₁𝐯₁ + ⋯ + cₖ𝐯ₖ = 𝐛**

**Span:    span(S) = {c₁𝐯₁ + ⋯ + cₖ𝐯ₖ}**

**Independence test:    c₁𝐯₁ + ⋯ + cₖ𝐯ₖ = 𝟎**

**Span ℝᵐ: every row pivots.    Independent: every column pivots.**
